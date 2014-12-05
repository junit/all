package com.mokylin.game.server.message.impl;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.event.GameEventHandler;

public class CtxHandler implements GameEventHandler<ChannelHandlerContext, CtxMessage>{

	@Override
	public void onEvent(ChannelHandlerContext owner, CtxMessage event) {
		CtxMessage ret = new CtxMessage();
		owner.writeAndFlush(ret);
	}

}
