package com.mokylin.game.server;

import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.core.netty.Server;
import com.mokylin.game.server.message.MessageManager;

public class GameServer extends Server {
	private MessageManager messageManager;

	public GameServer(String name, int port) {
		super(name, port);
	}

	@Override
	protected boolean init() {
		messageManager.init();
		return true;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher();
	}

	@Override
	public void onStop() {
	}

}
