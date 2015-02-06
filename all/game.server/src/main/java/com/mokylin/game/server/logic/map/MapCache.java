package com.mokylin.game.server.logic.map;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.mokylin.game.server.config.Platform;

public class MapCache {
	private ConcurrentHashMap<MapKey, Map> maps = new ConcurrentHashMap<>();

	public Map get(Platform platform, int server, int model, int line) {
		return maps.get(new MapKey(platform, server, model, line));
	}

	public void add(List<Map> list) {
		for (Map map : list) {
			maps.put(map.getKey(), map);
		}
	}
}
