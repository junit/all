package com.mokylin.game.server.config;

import org.dom4j.Element;

public class ServerConfig {
	private ServerConfigKey key;
	
	public static ServerConfig create(Element element) {
		ServerConfig config = new ServerConfig();
		ServerConfigKey key = new ServerConfigKey(Platform.get(Integer.parseInt(element.attributeValue("platform"))), Integer.parseInt(element.attributeValue("id")));
		config.key = key;
		return config;
	}

	public ServerConfigKey getKey() {
		return key;
	}
}
