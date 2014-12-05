package com.mokylin.game.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mokylin.game.core.netty.Server;
import com.mokylin.game.server.config.ConfigManager;
import com.mokylin.game.server.message.MessageDispatcher;
import com.mokylin.game.server.message.MessageFactoryImpl;

public class Main {
	public static void main(String[] args) throws Exception {
		Injector injector = Guice.createInjector();
		ConfigManager configManager = injector.getInstance(ConfigManager.class);
		configManager.init();
		Server server = new Server("game", configManager.getGamePort(), injector.getInstance(MessageDispatcher.class), new MessageFactoryImpl());
		server.start();
	}
}
