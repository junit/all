package com.mokylin.game.server;

public class Main {
	public static void main(String[] args) {
		GameServer server = new GameServer("server", 5241);
		server.start();
	}
}
