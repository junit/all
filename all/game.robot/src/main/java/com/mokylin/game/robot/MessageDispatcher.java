package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.core.netty.GameHandlerAdapter;

public class MessageDispatcher extends GameHandlerAdapter {

	@Override
	protected void onRecvMsg(Handler handler) {
		// TODO Auto-generated method stub
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.error("connect success full");
	}
}
