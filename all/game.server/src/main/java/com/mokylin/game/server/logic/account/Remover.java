package com.mokylin.game.server.logic.account;

import com.mokylin.game.core.cache.IRemover;

public class Remover implements IRemover<Account> {

	@Override
	public boolean canRemove(Account v) {
		return !v.isOnline();
	}

}
