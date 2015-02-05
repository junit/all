package com.mokylin.game.server.config;

import org.dom4j.Element;

public class OneServerConfig {
	private int id;
	public int getId() {
		return id;
	}
	
	public static OneServerConfig create(Element element) {
		OneServerConfig config = new OneServerConfig();
		config.id = Integer.parseInt(element.attributeValue("id"));
		return config;
	}
}
