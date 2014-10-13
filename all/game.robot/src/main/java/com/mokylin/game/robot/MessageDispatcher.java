package com.mokylin.game.robot;

import java.util.concurrent.atomic.AtomicInteger;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.robot.logic.login.message.ReqLoginMessage;

public class MessageDispatcher extends GameHandlerAdapter {
	private RobotClient robot;

	public MessageDispatcher(RobotClient robot) {
		this.robot = robot;
	}

	@Override
	protected void onRecvMsg(Handler handler) {
		handler.exec();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ReqLoginMessage msg = new ReqLoginMessage();
		msg.setName(robot.getName());
		msg.setServerId(1);
		msg.setPassword("x");
		ctx.writeAndFlush(msg);

		RobotClient.set(ctx, robot);

		int num = count.incrementAndGet();
		if (num % 1000 == 0) {
			logger.error("当前链接数量:" + num);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error(cause, cause);
	}

	private static AtomicInteger count = new AtomicInteger();

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.error("当前链接数量:" + count.decrementAndGet());
	}
}
