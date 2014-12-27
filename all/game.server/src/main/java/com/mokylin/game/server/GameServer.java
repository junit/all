package com.mokylin.game.server;

import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.core.netty.Server;
import com.mokylin.game.server.logic.test.handler.ReqTestHandler;
import com.mokylin.game.server.logic.test.message.ReqTestMessage;

public class GameServer extends Server {

	public GameServer(String name, int port) {
		super(name, port);
	}

	@Override
	protected boolean init() {
		MessagePool.getInstance().register(100100, ReqTestHandler.class, ReqTestMessage.class);
		return true;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher();
	}

}
