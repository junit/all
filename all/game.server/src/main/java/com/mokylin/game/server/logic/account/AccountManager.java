package com.mokylin.game.server.logic.account;

import java.util.concurrent.ConcurrentHashMap;

import com.mokylin.game.core.util.CommonUtil;
import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.config.Platform;

public class AccountManager {
	private ConcurrentHashMap<Long, Account> accounts = new ConcurrentHashMap<>();
	private ConcurrentHashMap<String, ConcurrentHashMap<Platform, ConcurrentHashMap<Integer, Account>>> accounts0 = new ConcurrentHashMap<>();

	public boolean init() {
		// TODO
		return true;
	}

	public Account get(String accountName, Platform platform, int server) {
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

	public Account create(String name, Platform platform, int server) {
		if (!ManagerPool.name.check(name)) {
			return null;
		}

		Account account = new Account();
		account.setId(CommonUtil.uid(platform.getValue(), server));
		account.setName(name);
		account.setPlatform(platform);
		account.setServer(server);
		account.setCreateTime(System.currentTimeMillis());
		account.setLoginTime(account.getCreateTime());

		add(account);
		return account;
	}

	private void add(Account account) {
		accounts.put(account.getId(), account);

		synchronized (accounts0) {
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
	}

	public boolean checkKey(Account account, String check) {
		// TODO
		return true;
	}
}
