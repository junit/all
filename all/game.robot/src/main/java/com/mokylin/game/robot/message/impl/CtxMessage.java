package com.mokylin.game.robot.message.impl;

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
		return true;
	}

	@Override
	public boolean write(ByteBuf buf) {
		// TODO Auto-generated method stub
		return true;
	}

}
