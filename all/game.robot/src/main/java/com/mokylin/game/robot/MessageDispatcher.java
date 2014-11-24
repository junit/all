package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.atomic.AtomicInteger;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.netty.GameHandlerAdapter;

public class MessageDispatcher extends GameHandlerAdapter {
	@Override
	protected void channelRead(ChannelHandlerContext ctx, Message msg) {
		Handler handler = MessagePool.getInstance().createHandler(msg.getId());
		try {
			handler.exec();
		} catch (Exception e) {

		}
	}

	private static AtomicInteger count = new AtomicInteger();

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {}

	@Override
	protected void readIdle(ChannelHandlerContext ctx) {}

	@Override
	protected void writeIdle(ChannelHandlerContext ctx) {
	}

	@Override
	protected void allIdle(ChannelHandlerContext ctx) {
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error(cause, cause);
	}
}
