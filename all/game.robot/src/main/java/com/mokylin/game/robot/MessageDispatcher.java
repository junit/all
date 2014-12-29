package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.robot.logic.login.message.ReqLoginMessage;

public class MessageDispatcher extends GameHandlerAdapter {
	private String name;
	public MessageDispatcher(String name) {
		this.name = name;
	}

	@Override
	protected void onRecvMsg(Handler handler) {
		handler.exec();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ReqLoginMessage msg = new ReqLoginMessage();
		msg.setName(name);
		msg.setServerId(1);
		msg.setPassword("x");
		ctx.writeAndFlush(msg);
	}
}
