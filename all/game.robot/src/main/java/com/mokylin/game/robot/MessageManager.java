package com.mokylin.game.robot;

import com.mokylin.game.core.message.MessagePool;

public class MessageManager {
	public boolean init() {
		MessagePool.getInstance().register(100201, com.mokylin.game.robot.logic.login.handler.ResLoginFailedHandler.class, com.mokylin.game.robot.logic.login.message.ResLoginFailedMessage.class);
		MessagePool.getInstance().register(100202, com.mokylin.game.robot.logic.login.handler.ResLoginTestHandler.class, com.mokylin.game.robot.logic.login.message.ResLoginTestMessage.class);
		return true;
	}
}
