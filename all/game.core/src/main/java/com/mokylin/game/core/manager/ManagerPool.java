package com.mokylin.game.core.manager;

import java.util.HashSet;

public abstract class ManagerPool {
	private HashSet<Manager> managers = new HashSet<>();
	
	public boolean onStart() {
		for (Manager manager : managers) {
			if (!manager.onStart()) {
				return false;
			}
		}
		return true;
	}
	
	public void onStop() {
		for (Manager manager : managers) {
			manager.onStop();
		}
	}
	
	public void regist(Manager manager) {
		managers.add(manager);
	}
}
