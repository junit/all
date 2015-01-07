package com.mokylin.game.server.logic.account;

import org.apache.log4j.Logger;

import com.mokylin.game.core.cache.ILoader;

public class Loader implements ILoader<AccountKey, Account> {
	private static Logger logger = Logger.getLogger(Loader.class);

	@Override
	public Account load(AccountKey k) {
		Account account = new Account();
		account.setId(k.getId());
		account.setName(k.getName());
		account.setServer(k.getServer());
		account.setOnline(true);
		return account;
	}

	@Override
	public void save(Account v) {
		logger.error("保存:" + v);
	}

	@Override
	public void onSaveFailed(Account v) {
		logger.error("保存失败:" + v);
	}

	@Override
	public boolean canRemove(Account v) {
		return !v.isOnline();
	}
}
