package com.mokylin.game.server.message.impl;

import io.netty.channel.ChannelHandlerContext;

import com.mokylin.game.core.event.GameEventHandler;

public class AccountHandler implements GameEventHandler<ChannelHandlerContext, AccountMessage>{

	@Override
	public void onEvent(ChannelHandlerContext owner, AccountMessage event) {
		// TODO Auto-generated method stub
		
	}

}
