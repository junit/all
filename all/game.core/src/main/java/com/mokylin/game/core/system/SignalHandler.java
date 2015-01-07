package com.mokylin.game.core.system;

import com.mokylin.game.core.netty.Server;

import sun.misc.Signal;

@SuppressWarnings("restriction")
public class SignalHandler implements sun.misc.SignalHandler {
	private Server server;
	public SignalHandler(Server server) {
		this.server = server;
	}

	@Override
	public void handle(Signal signal) {
		server.stopManual();
	}
}
