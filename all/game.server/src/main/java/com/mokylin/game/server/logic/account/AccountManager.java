package com.mokylin.game.server.logic.account;

import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.mokylin.game.core.util.CommonUtil;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.config.Platform;
import com.mokylin.game.server.context.ContextAttribute;
import com.mokylin.game.server.db.data.bean.AccountBean;
import com.mokylin.game.server.logic.GameEventPool;
import com.mokylin.game.server.logic.account.consts.RetCode;
import com.mokylin.game.server.logic.account.message.ReqAccountLoginMessage;
import com.mokylin.game.server.logic.account.message.ResAccountLoginFailedMessage;
import com.mokylin.game.server.logic.role.message.ResRoleInfoMessage;

public class AccountManager {
	private Logger logger = Logger.getLogger(this.getClass());
	private AccountCache cache = new AccountCache();

	public boolean init() {
		if (!cache.init()) return false;
		return true;
	}

	public Account get(String accountName, Platform platform, int server) {
		return cache.get(accountName, platform, server);
	}

	public Account create(String name, Platform platform, int server) {
		if (!ManagerPool.name.check(name)) {
			return null;
		}

		Account account = new Account();
		account.setId(CommonUtil.uid(platform.getValue(), server));
		account.setName(name);
		account.setPlatform(platform);
		account.setServer(server);
		account.setCreateTime(System.currentTimeMillis());

		add(account);
		return account;
	}

	private void add(Account account) {
		cache.add(account);
	}

	public boolean checkKey(Account account, String check) {
		// TODO
		return true;
	}

	public Account get(long id) {
		return cache.get(id);
	}

	public void login(ChannelHandlerContext ctx, ReqAccountLoginMessage msg) {
    	try {
    		Long accountId = null;
    		synchronized (ctx) { // 改变和获取的时候,加锁
    			accountId = ctx.attr(ContextAttribute.ACCOUNT_ID).get();
    		}
    		if (accountId != null) {
    			sendError(ctx, RetCode.LOGINED);
    			return ;
    		}
    		
    		if (ManagerPool.config.getServerConfig(Platform.get(msg.getPlatform()), msg.getServer()) == null) { // server 判定
    			sendError(ctx, RetCode.SERVER_ERROR);
    			return ;
    		}
    		
    		Account account = ManagerPool.account.get(msg.getAccountName(), Platform.get(msg.getPlatform()), msg.getServer());
    		if (account == null) {
    			account = ManagerPool.account.create(msg.getAccountName(), Platform.get(msg.getPlatform()), msg.getServer());
    		}
    		
    		if (account == null) {
    			sendError(ctx, RetCode.CRATE_ERROR);
    			return ;
    		}
    		
    		if (!ManagerPool.account.checkKey(account, msg.getCheck())) {
    			sendError(ctx, RetCode.KEY_ERROR);
    			return ;
    		}
    		
    		onLoginSuc(ctx, account);
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
	
	private void onLoginSuc(ChannelHandlerContext context, Account account) {
		ChannelHandlerContext oldContext = ManagerPool.context.getContexts().get(account.getId());
		if (oldContext != null) {
			ContextUtil.close(oldContext, "顶号");
		}
		ManagerPool.context.getContexts().put(account.getId(), context);
		synchronized (context) { // 改变和获取的时候,加锁
			context.attr(ContextAttribute.ACCOUNT_ID).set(account.getId());
		}
		sendError(context, RetCode.SUC);
		
		GameEventPool.account.onLogin(account);
	}

	private void sendError(ChannelHandlerContext ctx, RetCode code) {
		ResAccountLoginFailedMessage msg = new ResAccountLoginFailedMessage();
		msg.setErr(code.getValue());
		ManagerPool.context.write(ctx, msg);
	}

	public void send(Account account) {
		ResRoleInfoMessage msg = new ResRoleInfoMessage();
		msg.setRoles(ManagerPool.role.getRoleInfoList(account, msg.getRoles()));
		ManagerPool.context.write(account, msg);
	}

	public Account create(AccountBean bean) {
		Account account = new Account();
		account.setId(bean.getId());
		account.setName(bean.getName());
		account.setPlatform(Platform.get(bean.getPlatform()));
		account.setServer(bean.getServer());
		account.setCreateTime(bean.getCreateTime());
		return account;
	}
	
	private static AtomicInteger suc = new AtomicInteger(0);
	private static AtomicInteger fail = new AtomicInteger(0);
	public static void main(String[] args) {
		ManagerPool.name.init();
		ManagerPool.config.init();
		ReqAccountLoginMessage msg = new ReqAccountLoginMessage();
		msg.setAccountName("shell");
		msg.setCheck("");
		msg.setPlatform(1);
		msg.setServer(1);
		
		ThreadPoolExecutor excutor = new ThreadPoolExecutor(100, 100, 0, TimeUnit.DAYS, new LinkedBlockingQueue<>());
		for (int i = 0; i < 100; ++i) {
			excutor.execute(new Runnable() {
				@Override
				public void run() {
					ManagerPool.account.login(null, msg);
				}
			});
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("suc:" + suc);
		System.err.println("fail:" + fail);
	}
}
