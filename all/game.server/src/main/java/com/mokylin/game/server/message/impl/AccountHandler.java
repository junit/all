package com.mokylin.game.server.message.impl;

import com.mokylin.game.core.event.GameEventHandler;
import com.mokylin.game.server.logic.account.Account;

public class AccountHandler implements GameEventHandler<Account, AccountMessage>{

	@Override
	public void onEvent(Account owner, AccountMessage event) {
	}
}
