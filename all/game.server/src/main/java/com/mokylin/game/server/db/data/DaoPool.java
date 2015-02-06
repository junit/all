package com.mokylin.game.server.db.data;

import com.mokylin.game.server.db.data.dao.RoleDao;
import com.mokylin.game.server.db.data.dao.AccountDao;

public class DaoPool {
	public static RoleDao roleDao = new RoleDao();
	public static AccountDao accountDao = new AccountDao();
}
