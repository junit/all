package com.mokylin.game.server.manager;

import com.mokylin.game.server.logic.account.AccountManager;

public class ManagerPool extends com.mokylin.game.core.manager.ManagerPool {
	public static AccountManager account = new AccountManager();
}
