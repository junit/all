package com.mokylin.game.server.message.impl;

import io.netty.buffer.ByteBuf;

import com.mokylin.game.core.message.Message;

public class CtxMessage extends Message {

	@Override
	public int getId() {
		return 1;
	}

	@Override
	public boolean read(ByteBuf buf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean write(ByteBuf buf) {
		// TODO Auto-generated method stub
		return false;
	}

}
