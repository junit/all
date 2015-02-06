package com.mokylin.game.server.thread;

import com.mokylin.game.core.thread.GameThreadGroup;

public class ThreadManager {
	private GameThreadGroup accountThreadGroup;
	private GameThreadGroup loadThreadGroup;
	private GameThreadGroup saveThreadGroup;
	
	public boolean init() {
		accountThreadGroup = new GameThreadGroup("AccountThread", Runtime.getRuntime().availableProcessors() * 2);
		loadThreadGroup = new GameThreadGroup("LoadThreadGroup", Runtime.getRuntime().availableProcessors());
		saveThreadGroup = new GameThreadGroup("SaveThreadGroup", Runtime.getRuntime().availableProcessors());
		return true;
	}
	
	public GameThreadGroup getAccountThreadGroup() {
		return accountThreadGroup;
	}
	
	public GameThreadGroup getLoadThreadGroup() {
		return loadThreadGroup;
	}
	
	public GameThreadGroup getSaveThreadGroup() {
		return saveThreadGroup;
	}
}
