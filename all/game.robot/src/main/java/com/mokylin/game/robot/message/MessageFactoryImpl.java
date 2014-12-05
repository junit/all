package com.mokylin.game.robot.message;

import com.google.inject.Singleton;
import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.message.MessageFactory;
import com.mokylin.game.robot.message.impl.AccountMessage;
import com.mokylin.game.robot.message.impl.CtxMessage;

@Singleton
public class MessageFactoryImpl implements MessageFactory {

	@Override
	public Message newInstance(int id) {
		switch (id) {
		case 1: return new CtxMessage();
		case 2: return new AccountMessage();
		}
		return null;
	}

}
