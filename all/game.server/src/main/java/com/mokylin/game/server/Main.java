package com.mokylin.game.server;

import com.mokylin.game.server.manager.ManagerPool;


public class Main {
	public static void main(String[] args) {
		if (!ManagerPool.onStart()) {
			return ;
		}
		GameServer server = new GameServer("server", 5241);
		server.start();
	}
}
