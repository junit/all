package com.mokylin.game.server.logic.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
		// TODO Auto-generated method stub
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
}
