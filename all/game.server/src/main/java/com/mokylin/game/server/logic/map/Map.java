package com.mokylin.game.server.logic.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.config.ServerConfig;
import com.mokylin.game.server.db.config.bean.MapBean;
import com.mokylin.game.server.logic.role.Role;


public class Map {
	private MapKey key;
	private MapObjectGroup group = new MapObjectGroup();
	private Area[][] areas;

	public MapKey getKey() {
		return key;
	}

	public void setKey(MapKey key) {
		this.key = key;
	}

	public void add(Role role) {
		group.add(role);
		Area area = getArea(role.getMap().getCoordinate());
		area.add(role);
	}

	public Area getArea(Coordinate coordinate) {
		return areas[coordinate.getX() / Area.AREA_X][coordinate.getY() / Area.AREA_Y];
	}

	public Coordinate correct(Coordinate coordinate) {
		// TODO 矫正非法
		return coordinate;
	}

	public Collection<Role> getRoundRoles(Coordinate coordinate) {
		List<Role> roles = new ArrayList<>();
		for (int x = coordinate.getX() / Area.AREA_X - 1; x <= coordinate.getX() / Area.AREA_X + 1; ++x) {
			for (int y = coordinate.getY() / Area.AREA_Y - 1; y <= coordinate.getY() / Area.AREA_Y + 1; ++y) {
				roles.addAll(areas[x][y].getRoles());
			}
		}
		return roles;
	}

	public static List<Map> create(MapBean bean) {
		List<Map> maps = new ArrayList<>();
		for (ServerConfig config : ManagerPool.config.getConfigs()) {
			for (int line = 1; line <= bean.getMax_line(); ++line) {
				Map map = new Map();
				map.setKey(new MapKey(config.getKey().getPlatform(), config.getKey().getServer(), bean.getId(), line));
				map.init(bean);
				maps.add(map);
			}
		}
		return maps;
	}

	private void init(MapBean bean) {
		int x = (int)Math.ceil((double)bean.getX_len() / Area.AREA_X);
		int y = (int)Math.ceil((double)bean.getY_len() / Area.AREA_Y);
		areas = new Area[x][y];
	}
}
