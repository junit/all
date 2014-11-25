package com.mokylin.game.server.config;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigManager {
	private Logger logger = Logger.getLogger(ConfigManager.class);
	private int gamePort;
	private int maxSession;
	private ConcurrentHashMap<ServerConfigKey, ServerConfig> configs = new ConcurrentHashMap<>(); // 多服务器配置

	public int getGamePort() {
		return gamePort;
	}

	public int getMaxSession() {
		return maxSession;
	}

	public boolean init() {
		try {
		File file = new File("config/server.xml");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(file);
		Element root = doc.getRootElement();

		Element gameServer = root.element("gameserver");
		gamePort = Integer.parseInt(gameServer.attributeValue("port"));
		maxSession = Integer.parseInt(gameServer.attributeValue("max_session"));

		Element servers = root.element("servers");
		for (Iterator<?> i = servers.elementIterator("server"); i.hasNext();) {
			Element element = (Element) i.next();
			ServerConfig oneConfig = ServerConfig.create(element);
			configs.put(oneConfig.getKey(), oneConfig);
		}
		} catch (Exception e) {
			logger.error(e, e);
			return false;
		}
		return true;
	}
	
	public Collection<ServerConfig> getConfigs() {
		return configs.values();
	}

	public Object getServerConfig(Platform platform, int server) {
		return configs.get(new ServerConfigKey(platform, server));
	}
}
