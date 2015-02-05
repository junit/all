package com.mokylin.game.server.config;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigManager {
	private int gamePort;
	private int maxSession;
	private ConcurrentHashMap<Integer, OneServerConfig> configs = new ConcurrentHashMap<>(); // 多服务器配置

	public ConcurrentHashMap<Integer, OneServerConfig> getConfigs() {
		return configs;
	}

	public int getGamePort() {
		return gamePort;
	}
	
	public int getMaxSession() {
		return maxSession;
	}

	public void init() throws Exception {
		File file = new File("config/server.xml");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(file);
		Element root = doc.getRootElement();
		
		Element gameServer = root.element("gameserver");
		gamePort = Integer.parseInt(gameServer.attributeValue("port"));
		maxSession = Integer.parseInt(gameServer.attributeValue("max_session"));
		
		Element servers = root.element("servers");
		for (Iterator<?> i = servers.elementIterator("server"); i.hasNext(); ) {
			Element element = (Element)i.next();
			OneServerConfig oneConfig = OneServerConfig.create(element);
			configs.put(oneConfig.getId(), oneConfig);
		}
	}
}
