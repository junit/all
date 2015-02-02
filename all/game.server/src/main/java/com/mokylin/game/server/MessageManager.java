package com.mokylin.game.server;

import com.mokylin.game.core.message.MessagePool;

public class MessageManager {
	public boolean init() {
		MessagePool.getInstance().register(100101, com.mokylin.game.server.logic.login.handler.ReqLoginHandler.class, com.mokylin.game.server.logic.login.message.ReqLoginMessage.class);
		return true;
	}
}
