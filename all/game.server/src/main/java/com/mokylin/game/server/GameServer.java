package com.mokylin.game.server;

import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.core.netty.Server;

public class GameServer extends Server {

	public GameServer(String name, int port) {
		super(name, port);
	}

	@Override
	protected boolean init() {
		if (!ManagerPool.message.init())	return false;
		if (!ManagerPool.account.init()) return false;
		if (!ManagerPool.scheduler.init()) return false;
		if (!ManagerPool.name.init()) return false;
		if (!ManagerPool.thread.init()) return false;
		if (!ManagerPool.map.init()) return false;
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
