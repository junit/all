package com.mokylin.game.server.db.data;

import com.mokylin.game.server.db.data.dao.AccountDao;

public class DaoPool {
	public static AccountDao accountDao = new AccountDao();
}
