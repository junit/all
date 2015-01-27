package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ConnectTimeoutException;

import java.util.concurrent.atomic.AtomicInteger;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.robot.logic.login.message.ReqLoginMessage;
import com.mokylin.game.robot.logic.player.message.ReqPlayerTestMessage;

public class MessageDispatcher extends GameHandlerAdapter {
	@Override
	protected void onRecvMsg(Handler handler) {
		handler.exec();
	}

	private static AtomicInteger count = new AtomicInteger();
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ReqLoginMessage msg = new ReqLoginMessage();
		msg.setName(Main.PREFIX + count.incrementAndGet());
		msg.setServerId(1);
		msg.setPassword("x");
		ctx.writeAndFlush(msg);
	}
	
	@Override
	protected void readIdle(ChannelHandlerContext ctx) {
		ReqPlayerTestMessage msg = new ReqPlayerTestMessage();
		msg.setFlag(System.currentTimeMillis());
		ctx.writeAndFlush(msg);
	}

	@Override
	protected void writeIdle(ChannelHandlerContext ctx) {
	}

	@Override
	protected void allIdle(ChannelHandlerContext ctx) {
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if (cause instanceof ConnectTimeoutException) {
			logger.error("草啊！链接超时来");
		}
		logger.error(cause, cause);
	}
}
