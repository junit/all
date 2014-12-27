package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.robot.logic.test.message.ReqTestMessage;

public class MessageDispatcher extends GameHandlerAdapter {

	@Override
	protected void onRecvMsg(Handler handler) {
		handler.exec();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.error("connect success full");
		ReqTestMessage msg = new ReqTestMessage();
		msg.setTime(System.currentTimeMillis());
		ctx.writeAndFlush(msg);
	}
}
