package com.mokylin.game.server.manager;

import com.mokylin.game.core.scheduler.SchedulerManager;
import com.mokylin.game.server.logic.account.AccountManager;

public class ManagerPool extends com.mokylin.game.core.manager.ManagerPool {
	private static ManagerPool instance = new ManagerPool();
	public static ManagerPool getInstance() { return instance; }
	
	public static AccountManager account = new AccountManager(instance);
	public static SchedulerManager scheduler = new SchedulerManager(instance);
}
