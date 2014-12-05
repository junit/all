package com.mokylin.game.server.logic.account;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mokylin.game.core.common.IdFactory;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.server.config.ConfigManager;
import com.mokylin.game.server.config.Platform;
import com.mokylin.game.server.context.ContextAttribute;
import com.mokylin.game.server.context.ContextManager;
import com.mokylin.game.server.db.data.bean.AccountBean;
import com.mokylin.game.server.logic.account.consts.RetCode;
import com.mokylin.game.server.logic.account.message.ReqAccountLoginMessage;
import com.mokylin.game.server.logic.account.message.ResAccountLoginFailedMessage;
import com.mokylin.game.server.logic.role.RoleManager;
import com.mokylin.game.server.logic.role.message.ResRoleInfoMessage;
import com.mokylin.game.server.name.NameManager;

@Singleton
public class AccountManager {
	private final NameManager nameManager;
	private final ConfigManager configManager;
	private final ContextManager contextManager;
	private final RoleManager roleManager;
	private final AccountCache cache;
	private final IdFactory idFactory;
	
	@Inject
	public AccountManager(NameManager nameManager, ConfigManager configManager, ContextManager contextManager, RoleManager roleManager, AccountCache cache, IdFactory factory) {
		this.nameManager = nameManager;
		this.configManager = configManager;
		this.contextManager = contextManager;
		this.roleManager = roleManager;
		this.cache = cache;
		this.idFactory = factory;
	}
	
	private Logger logger = Logger.getLogger(this.getClass());

	public Account get(String accountName, Platform platform, int server) {
		return cache.get(accountName, platform, server);
	}

	public Account create(String name, Platform platform, int server) {
		if (!nameManager.check(name)) {
			return null;
		}

		Account account = new Account();
		account.setId(idFactory.uid(platform.getValue(), server));
		account.setName(name);
		account.setPlatform(platform);
		account.setServer(server);
		account.setCreateTime(System.currentTimeMillis());

		add(account);

//		final AccountBean bean = create(account); 
//		try {
//			ManagerPool.thread.getSaveThreadGroup().add(account, new Event() {
//				
//				@Override
//				public void exec() throws Exception {
//					DaoPool.accountDao.insert(bean);
//				}
//				
//				@Override
//				public int timeOutMs() {
//					return 100;
//				}
//			});
//		} catch (Exception e) {
//			logger.error(e, e);
//		}
		return account;
	}

	public static AccountBean create(Account account) {
		AccountBean bean = new AccountBean();
		bean.setId(account.getId());
		bean.setName(account.getName());
		bean.setPlatform(account.getPlatform().getValue());
		bean.setServer(account.getServer());
		bean.setCreateTime(account.getCreateTime());
		return bean;
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
    		
    		if (configManager.getServerConfig(Platform.get(msg.getPlatform()), msg.getServer()) == null) { // server 判定
    			sendError(ctx, RetCode.SERVER_ERROR);
    			return ;
    		}
    		
    		Account account = get(msg.getAccountName(), Platform.get(msg.getPlatform()), msg.getServer());
    		if (account == null) {
    			account = create(msg.getAccountName(), Platform.get(msg.getPlatform()), msg.getServer());
    		}
    		
    		if (account == null) {
    			sendError(ctx, RetCode.CRATE_ERROR);
    			return ;
    		}
    		
    		if (!checkKey(account, msg.getCheck())) {
    			sendError(ctx, RetCode.KEY_ERROR);
    			return ;
    		}
    		
    		onLoginSuc(ctx, account);
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
	
	private void onLoginSuc(ChannelHandlerContext context, Account account) {
		ChannelHandlerContext oldContext = contextManager.getContexts().get(account.getId());
		if (oldContext != null) {
			ContextUtil.close(oldContext, "顶号");
		}
		contextManager.getContexts().put(account.getId(), context);
		synchronized (context) { // 改变和获取的时候,加锁
			context.attr(ContextAttribute.ACCOUNT_ID).set(account.getId());
		}
		sendError(context, RetCode.SUC);

		// TODO
	}

	private void sendError(ChannelHandlerContext ctx, RetCode code) {
		ResAccountLoginFailedMessage msg = new ResAccountLoginFailedMessage();
		msg.setErr(code.getValue());
		contextManager.write(ctx, msg);
	}

	public void send(Account account) {
		ResRoleInfoMessage msg = new ResRoleInfoMessage();
		msg.setRoles(roleManager.getRoleInfoList(account, msg.getRoles()));
		contextManager.write(account, msg);
	}

	public static Account create(AccountBean bean) {
		Account account = new Account();
		account.setId(bean.getId());
		account.setName(bean.getName());
		account.setPlatform(Platform.get(bean.getPlatform()));
		account.setServer(bean.getServer());
		account.setCreateTime(bean.getCreateTime());
		return account;
	}
}
