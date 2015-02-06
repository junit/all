package com.mokylin.game.server.logic.map;

import java.util.Collection;

import com.mokylin.game.server.logic.role.Role;

public class Area {
	public final static int AREA_X = 16;
	public final static int AREA_Y = 10;
	
	private MapObjectGroup group = new MapObjectGroup();

	public void add(Role role) {
		group.add(role);
	}

	public Collection<? extends Role> getRoles() {
		return group.getRoles();
	}
}
