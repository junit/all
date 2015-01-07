package com.mokylin.game.server.logic.account;

import org.apache.log4j.Logger;

import com.mokylin.game.core.cache.Cache;
import com.mokylin.game.core.cache.ICallBack;
import com.mokylin.game.core.manager.Manager;
import com.mokylin.game.server.manager.ManagerPool;

public class AccountManager extends Manager {
	private static Logger logger = Logger.getLogger(AccountManager.class);
	@SuppressWarnings("unchecked")
	private Cache<AccountKey, Account> cache = Cache.build(new Loader(), new Remover(), 30 * 1000L, 20000, 9, "account_cache");
	@Override
	public boolean onStart() {
		return true;
	}

	@Override
	public void onStop() {
	}

	public Cache<AccountKey, Account> getCache() {
		return cache;
	}
	
	public static void main(String[] args) {
		ManagerPool.onStart();
		
		ManagerPool.account.cache.get(new AccountKey("shell", 1), new ICallBack<Account>() {
			@Override
			public void exec(Account v) {
				logger.error("加载成功:" + v);
				v.setOnline(false);
			}
		});
	}
}
