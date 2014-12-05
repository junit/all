package com.mokylin.game.server.logic.account;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mokylin.game.server.config.Platform;
import com.mokylin.game.server.db.data.bean.AccountBean;
import com.mokylin.game.server.db.data.dao.AccountDao;

@Singleton
public class AccountCache {
	private ConcurrentHashMap<Long, Account> accounts = new ConcurrentHashMap<>();
	private ConcurrentHashMap<String, ConcurrentHashMap<Platform, ConcurrentHashMap<Integer, Account>>> accounts0 = new ConcurrentHashMap<>();
	
	@Inject
	public AccountCache(AccountDao dao) {
		List<AccountBean> list = dao.select();
		for (AccountBean bean : list) {
			add(AccountManager.create(bean));
		}
	}

	public synchronized Account get(String accountName, Platform platform, int server) {
		ConcurrentHashMap<Platform, ConcurrentHashMap<Integer, Account>> accounts1 = accounts0.get(accountName);
		if (accounts1 == null) {
			return null;
		}
		ConcurrentHashMap<Integer, Account> accounts2 = accounts1.get(platform);
		if (accounts2 == null) {
			return null;
		}
		return accounts2.get(server);
	}

	public synchronized void add(Account account) {
		accounts.put(account.getId(), account);

		ConcurrentHashMap<Platform, ConcurrentHashMap<Integer, Account>> accounts1 = accounts0.get(account.getName());
		if (accounts1 == null) {
			accounts1 = new ConcurrentHashMap<>();
			accounts0.put(account.getName(), accounts1);
		}

		ConcurrentHashMap<Integer, Account> accounts2 = accounts1.get(account.getPlatform());
		if (accounts2 == null) {
			accounts2 = new ConcurrentHashMap<>();
			accounts1.put(account.getPlatform(), accounts2);
		}
		accounts2.put(account.getServer(), account);
	}

	public Account get(long id) {
		return accounts.get(id);
	}
}
