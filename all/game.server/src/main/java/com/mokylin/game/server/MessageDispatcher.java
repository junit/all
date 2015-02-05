package com.mokylin.game.server;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.server.context.ContextAttribute;
import com.mokylin.game.server.logic.account.Account;

public class MessageDispatcher extends GameHandlerAdapter {
	private static Logger logger = Logger.getLogger(MessageDispatcher.class);

	@Override
	protected void onRecvMsg(Handler handler) {
		if (handler.getMessage().getId() == 100101) { // 登录
			handler.exec();
			return ;
		}
		
		Long accountId = null;
		synchronized (handler.getContext()) { // 改变和获取的时候,加锁
			accountId = handler.getContext().attr(ContextAttribute.ACCOUNT_ID).get();
		}
		if (accountId == null) {
			ContextUtil.close(handler.getContext(), "未登录的帐号");
			return ;
		}
		Account account = ManagerPool.account.get(accountId);
		if (account == null) {
			ContextUtil.close(handler.getContext(), "未登录的帐号");
			return ;
		}
		try {
			ManagerPool.thread.getAccountThreadGroup().add(account, handler);
		} catch (Exception e) {
			logger.error(e, e);
		}
	}

	private static AtomicInteger count = new AtomicInteger();
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.error(count.incrementAndGet());
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.error(count.decrementAndGet());
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
