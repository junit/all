package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.atomic.AtomicInteger;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.robot.logic.login.message.ReqLoginMessage;
import com.mokylin.game.robot.logic.login.message.ReqLoginTestMessage;

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
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ReqLoginMessage msg = new ReqLoginMessage();
		msg.setAccountName(Main.PREFIX + count.incrementAndGet());
		msg.setServer(1);
		msg.setPlatform(1);
		msg.setCheck("check");
		ContextUtil.write(ctx, msg);
	}

	@Override
	protected void readIdle(ChannelHandlerContext ctx) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 1024; ++i) {
			builder.append(0);
		}
		ReqLoginTestMessage msg = new ReqLoginTestMessage();
		msg.setStr(builder.toString());
		msg.setTime(System.currentTimeMillis());
		ContextUtil.write(ctx, msg);
	}

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
