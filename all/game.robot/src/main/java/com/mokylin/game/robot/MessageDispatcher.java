package com.mokylin.game.robot;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.robot.logic.account.message.ReqAccountLoginMessage;

public class MessageDispatcher extends GameHandlerAdapter {
	private static Logger logger = Logger.getLogger(MessageDispatcher.class);
	@Override
	protected void channelRead(ChannelHandlerContext ctx, Message msg) {
		Handler handler = MessagePool.getInstance().createHandler(msg.getId());
		try {
			handler.setExcutor(ctx);
			handler.setMessage(msg);
			handler.exec();
		} catch (Exception e) {

		}
	}
	
	private static AtomicInteger index = new AtomicInteger(0);

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Robot robot = new Robot();
		robot.setAccount("shell_" + index.incrementAndGet());
		robot.setCheck("null");
		robot.setPlatform(1);
		robot.setServer(1);
		
		Robot.bind(ctx, robot);
		
		ReqAccountLoginMessage msg = new ReqAccountLoginMessage();
		msg.setAccountName(robot.getAccount());
		msg.setCheck(robot.getCheck());
		msg.setPlatform(robot.getPlatform());
		msg.setServer(robot.getServer());
		ContextUtil.write(ctx, msg);
	}

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
