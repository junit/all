package com.mokylin.game.server.logic.account;

import org.apache.log4j.Logger;

import com.mokylin.game.core.cache.Cache;
import com.mokylin.game.core.manager.Manager;

public class AccountManager extends Manager {
	public AccountManager(com.mokylin.game.core.manager.ManagerPool pool) {
		super(pool);
	}

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(AccountManager.class);
	@SuppressWarnings("unchecked")
	private Cache<AccountKey, Account> cache = Cache.newCache("account_cache", new Loader(), 20000);
	@Override
	public boolean onStart() {
		return true;
	}

	@Override
	public void onStop() {
		cache.onStop();
	}

	public Cache<AccountKey, Account> getCache() {
		return cache;
	}
}
