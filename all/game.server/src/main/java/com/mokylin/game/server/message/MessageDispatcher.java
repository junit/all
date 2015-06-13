package com.mokylin.game.server.message;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.netty.HandlerAdapter;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.server.context.ContextAttribute;
import com.mokylin.game.server.event.ExcutorGroup;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.account.AccountManager;
import com.mokylin.game.server.logic.account.message.ReqAccountLoginMessage;
import com.mokylin.game.server.message.impl.CtxMessage;

@Singleton
@Sharable
public class MessageDispatcher extends HandlerAdapter {
	private static Logger logger = Logger.getLogger(MessageDispatcher.class);
	private final ExcutorGroup excutors;
	private final AccountManager accountManager;
	private final MessageHandlerGroup handlerGroup;
	
	@Inject
	public MessageDispatcher(ExcutorGroup excutors, AccountManager accountManager, MessageHandlerGroup handlerGroup) {
		this.excutors = excutors;
		this.accountManager = accountManager;
		this.handlerGroup = handlerGroup;
	}

	@Override
	protected void channelRead(ChannelHandlerContext ctx, Message msg) {
		Long accountId = null;
		synchronized (ctx) { // 改变和获取的时候,加锁
			accountId = ctx.attr(ContextAttribute.ACCOUNT_ID).get();
		}
		
		if (msg instanceof CtxMessage) { // 登录
			if (accountId != null) {
				ContextUtil.close(ctx, "已经登录过的账号");
				return ;
			}
			
			excutors.getLoginExcutor().excute(ctx, msg, handlerGroup.getCtxHandler(msg.getId()));
			return ;
		}
		
		if (accountId == null) {
			ContextUtil.close(ctx, "未登录的帐号");
			return ;
		}
		Account account = accountManager.get(accountId);
		if (account == null) {
			ContextUtil.close(ctx, "登录未完成的账号");
			return ;
		}
		
		excutors.getAccountExcutor().excute(account, msg, handlerGroup.getAccountHandler(msg.getId()));
	}
	
	private static AtomicInteger count = new AtomicInteger(0);

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.error("当前连接数量:" + count.incrementAndGet());
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.error("当前连接数量:" + count.decrementAndGet());
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error(cause, cause);
	}

	@Override
	protected void readIdle(ChannelHandlerContext ctx) {
		// do nothing
	}

	@Override
	protected void writeIdle(ChannelHandlerContext ctx) {
		// do noting
	}

	@Override
	protected void allIdle(ChannelHandlerContext ctx) {
		// do nothing
	}
}
