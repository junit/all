package com.mokylin.game.server.logic.role;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.mokylin.game.server.logic.account.Account;

public class RoleCache {
	private ConcurrentHashMap<Long, Role> roles = new ConcurrentHashMap<>();
	private ConcurrentHashMap<Account, List<Role>> roles0 = new ConcurrentHashMap<>();
	

	public List<Role> getRoles(Account account) {
		return roles0.get(account);
	}

	public void put(Account account, List<Role> list) {
		roles0.put(account, list);
		for (Role role : list) {
			roles.put(role.getId(), role);
		}
	}

	public Role getRole(int id) {
		return roles.get(id);
	}

}
