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
		logger.error(count.incrementAndGet());
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.error(count.decrementAndGet());
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
//		super.exceptionCaught(ctx, cause);
	}
}
