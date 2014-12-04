package com.mokylin.game.robot;

import com.mokylin.game.core.netty.Client;
import com.mokylin.game.core.netty.HandlerAdapter;


public class RobotClient extends Client {
	public RobotClient(String host, int port) {
		super(host, port);
	}

	@Override
	protected boolean init() {
		return true;
	}

	@Override
	protected HandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher();
	}
}
