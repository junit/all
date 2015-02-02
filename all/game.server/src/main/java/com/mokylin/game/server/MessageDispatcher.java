package com.mokylin.game.server;

import java.util.concurrent.atomic.AtomicInteger;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.core.netty.GameHandlerAdapter;

public class MessageDispatcher extends GameHandlerAdapter {

	@Override
	protected void onRecvMsg(Handler handler) {
		if (handler.getMessage().getId() == 100101) { // 登录
			handler.exec();
			return ;
		}
		// TODO
		handler.exec();
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
