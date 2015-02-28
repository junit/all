package com.mokylin.game.supserver;

import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.core.netty.Server;

public class SuperServer extends Server {

	public SuperServer(String name, int port) {
		super(name, port);
	}

	@Override
	protected boolean init() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

}
