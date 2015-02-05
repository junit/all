package com.mokylin.game.server.logic.account;

import com.mokylin.game.server.ManagerPool;

public class AccountEvent {

	public void onLogin(Account account) {
		// TODO 告知前端登录成功了
		
		ManagerPool.thread.getAccountThreadGroup().add(account);
	}

}
