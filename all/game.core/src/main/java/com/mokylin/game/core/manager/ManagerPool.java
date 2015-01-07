package com.mokylin.game.core.manager;

import java.util.HashSet;

import com.mokylin.game.core.scheduler.SchedulerManager;

public class ManagerPool {
	private static HashSet<Manager> managers = new HashSet<>();
	
	public static SchedulerManager scheduler = new SchedulerManager();
	
	public static boolean onStart() {
		for (Manager manager : managers) {
			if (!manager.onStart()) {
				return false;
			}
		}
		return true;
	}
	
	public static void onStop() {
		for (Manager manager : managers) {
			manager.onStop();
		}
	}
	
	public static void regist(Manager manager) {
		managers.add(manager);
	}
}
