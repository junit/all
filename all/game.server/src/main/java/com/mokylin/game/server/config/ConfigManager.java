package com.mokylin.game.server.config;

import java.util.concurrent.ConcurrentHashMap;

public class ConfigManager {
	private int gamePort;
	private ConcurrentHashMap<Integer, OneServerConfig> configs = new ConcurrentHashMap<>(); // 多服务器配置

	public ConcurrentHashMap<Integer, OneServerConfig> getConfigs() {
		return configs;
	}
	public int getGamePort() {
		return gamePort;
	}
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
