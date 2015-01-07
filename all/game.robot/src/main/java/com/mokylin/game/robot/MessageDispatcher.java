package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.atomic.AtomicInteger;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.core.netty.GameHandlerAdapter;

public class MessageDispatcher extends GameHandlerAdapter {
	private RobotClient robot;
	public MessageDispatcher(RobotClient robot) {
		this.robot = robot;
	}

	@Override
	protected void onRecvMsg(Handler handler) {
		handler.exec();
	}

	private static AtomicInteger count = new AtomicInteger();
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.error("当前玩家数量:" + count.incrementAndGet());
		
//		ReqLoginMessage msg = new ReqLoginMessage();
//		msg.setName(robot.getName());
//		msg.setServerId(1);
//		msg.setPassword("x");
//		ctx.writeAndFlush(msg);
		
		RobotClient.set(ctx, robot);
	}
	
	@Override
	protected void readIdle(ChannelHandlerContext ctx) {
//		ReqPlayerTestMessage msg = new ReqPlayerTestMessage();
//		msg.setFlag(System.currentTimeMillis());
//		ctx.writeAndFlush(msg);
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
