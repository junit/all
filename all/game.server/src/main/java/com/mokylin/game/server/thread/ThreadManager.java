package com.mokylin.game.server.thread;

import com.mokylin.game.core.thread.GameThreadGroup;

public class ThreadManager {
	GameThreadGroup accountThreadGroup;
	
	public boolean init() {
		accountThreadGroup = new GameThreadGroup("AccountThread");
		return true;
	}
	
	public GameThreadGroup getAccountThreadGroup() {
		return accountThreadGroup;
	}
}
