package com.mokylin.game.server.logic.account;

import org.apache.log4j.Logger;

import com.mokylin.game.core.cache.Cache;

public class AccountManager {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(AccountManager.class);
	@SuppressWarnings("unchecked")
	private Cache<AccountKey, Account> cache = Cache.newCache("account_cache", new Loader(), 20000);

	public Cache<AccountKey, Account> getCache() {
		return cache;
	}
}
