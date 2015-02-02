package com.mokylin.game.server;

public class Main {
	public static void main(String[] args) {
		ManagerPool.config.init();
		GameServer server = new GameServer("game", ManagerPool.config.getGamePort());
		server.start();
	}
}
