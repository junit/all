package com.mokylin.game.server.db.config;

import com.mokylin.game.server.db.config.container.MapContainer;

public class ContainerPool {
	public static MapContainer mapContainer = new MapContainer();

	public static void init() {
		mapContainer.init();
	}
}
