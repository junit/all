package com.mokylin.game.server.logic.map;

import java.util.List;

import org.apache.log4j.Logger;

import com.mokylin.game.server.db.config.ContainerPool;
import com.mokylin.game.server.db.config.bean.MapBean;
import com.mokylin.game.server.logic.GameEventPool;
import com.mokylin.game.server.logic.role.Role;

public class MapManager {
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	private MapCache cache = new MapCache();

	public void enter(Role role) {
		Map map = getMap(role);
		if (map != null) {
			return;
		}

		map = selectMap(role);
		if (map == null) {
			return;
		}

		role.getMap().setCoordinate(map.correct(role.getMap().getCoordinate()));

		map.add(role);
		GameEventPool.map.onEnterMap(role);
	}

	private Map selectMap(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map getMap(Role role) {
		return cache.get(role.getAccount().getPlatform(), role.getAccount().getServer(), role.getMap().getModel(), role.getMap().getLine());
	}

	public boolean init() {
		for (MapBean bean : ContainerPool.mapContainer.getList()) {
			List<Map> maps = Map.create(bean);
			cache.add(maps);
		}
		return true;
	}

}
