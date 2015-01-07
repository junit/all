package com.mokylin.game.server;

import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.core.netty.Server;
import com.mokylin.game.server.manager.ManagerPool;

public class GameServer extends Server {

	public GameServer(String name, int port) {
		super(name, port);
	}

	@Override
	protected boolean init() {
		if (!ManagerPool.getInstance().onStart()) {
			return false;
		}
		return true;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher();
	}

	@Override
	public void onStop() {
		ManagerPool.getInstance().onStop();
	}

}
