package com.mokylin.game.robot;

import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.netty.Client;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.robot.logic.test.handler.ResTestHandler;
import com.mokylin.game.robot.logic.test.message.ResTestMessage;

public class RobotClient extends Client {

	public RobotClient(String name, String host, int port) {
		super(name, host, port);
	}

	@Override
	protected boolean init() {
		MessagePool.getInstance().register(100200, ResTestHandler.class, ResTestMessage.class);
		return true;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher();
	}

}
