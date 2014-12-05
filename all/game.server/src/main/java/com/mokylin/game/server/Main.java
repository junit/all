package com.mokylin.game.server;

import com.mokylin.game.core.netty.Server;

public class Main {
	public static void main(String[] args) throws Exception {
		ManagerPool.config.init();
		Server server = new Server("game", ManagerPool.config.getGamePort(), null);
		server.start();
	}
}
