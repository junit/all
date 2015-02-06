package com.mokylin.game.server.logic.map;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import com.mokylin.game.server.logic.role.Role;

public class MapObjectGroup {
	private ConcurrentHashMap<Long, Role> roles = new ConcurrentHashMap<>();

	public void add(Role role) {
		roles.put(role.getId(), role);
	}

	public Collection<? extends Role> getRoles() {
		return roles.values();
	}
}
