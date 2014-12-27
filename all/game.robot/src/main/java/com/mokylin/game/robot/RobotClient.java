package com.mokylin.game.robot;

import com.mokylin.game.core.netty.Client;
import com.mokylin.game.core.netty.GameHandlerAdapter;

public class RobotClient extends Client {

	public RobotClient(String name, String host, int port) {
		super(name, host, port);
	}

	@Override
	protected boolean init() {
		return true;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher();
	}

}
