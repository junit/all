package com.mokylin.game.server;

import java.util.concurrent.atomic.AtomicInteger;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.core.netty.GameHandlerAdapter;

public class MessageDispatcher extends GameHandlerAdapter {

	@Override
	protected void onRecvMsg(Handler handler) {
		handler.exec();
	}

	private static AtomicInteger count = new AtomicInteger();
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.error(Thread.currentThread().getId());
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
		// TODO Auto-generated method stub
	}

	@Override
	protected void writeIdle(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void allIdle(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
	}
}
