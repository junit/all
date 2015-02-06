package com.mokylin.game.server.logic.map;

import java.util.concurrent.ConcurrentHashMap;

import com.mokylin.game.server.config.Platform;

public class MapCache {
	private ConcurrentHashMap<MapKey, Map> maps = new ConcurrentHashMap<>();

	public Map get(Platform platform, int server, int model, int line) {
		return maps.get(new MapKey(platform, server, model, line));
	}
}
