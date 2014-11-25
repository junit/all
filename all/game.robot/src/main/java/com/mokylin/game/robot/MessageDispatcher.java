package com.mokylin.game.robot;

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
	@SuppressWarnings("unused")
	private final RobotClient robot;
	public MessageDispatcher(RobotClient robot) {
		this.robot = robot;
	}
	@Override
	protected void channelRead(ChannelHandlerContext ctx, Message msg) {
		Handler handler = MessagePool.getInstance().createHandler(msg.getId());
		try {
			handler.exec();
		} catch (Exception e) {

		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ReqAccountLoginMessage msg = new ReqAccountLoginMessage();
		msg.setAccountName("shell1");
		msg.setCheck("check");
		msg.setPlatform(1);
		msg.setServer(1);
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
