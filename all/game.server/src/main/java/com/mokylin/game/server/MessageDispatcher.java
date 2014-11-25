package com.mokylin.game.server;

import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.server.context.ContextAttribute;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.account.message.ReqAccountLoginMessage;

public class MessageDispatcher extends GameHandlerAdapter {
	private static Logger logger = Logger.getLogger(MessageDispatcher.class);

	@Override
	protected void channelRead(ChannelHandlerContext ctx, Message msg) {
		if (msg instanceof ReqAccountLoginMessage) { // 登录
			Handler handler = MessagePool.getInstance().createHandler(msg.getId());
			handler.setExcutor(ctx);
			handler.setMessage(msg);
			try {
				handler.exec();
			} catch (Exception e) {
				logger.error(e, e);
			}
			return ;
		}
		
		Long accountId = null;
		synchronized (ctx) { // 改变和获取的时候,加锁
			accountId = ctx.attr(ContextAttribute.ACCOUNT_ID).get();
		}
		if (accountId == null) {
			ContextUtil.close(ctx, "未登录的帐号");
			return ;
		}
		Account account = ManagerPool.account.get(accountId);
		if (account == null) {
			ContextUtil.close(ctx, "未登录的帐号");
			return ;
		}
		
		Handler handler = MessagePool.getInstance().createHandler(msg.getId());
		handler.setExcutor(account);
		handler.setMessage(msg);
		
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
