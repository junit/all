package com.mokylin.game.core.manager;

public abstract class Manager {
	public Manager() {
		ManagerPool.regist(this);
	}
	public abstract boolean onStart();
	public abstract void onStop();
}
