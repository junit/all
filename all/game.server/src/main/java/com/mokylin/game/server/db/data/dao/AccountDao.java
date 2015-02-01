package com.mokylin.game.server.db.data.dao;

import java.util.List;

import com.mokylin.game.server.db.BaseDao;
import com.mokylin.game.server.db.data.bean.AccountBean;

public class AccountDao extends BaseDao<AccountBean> {

	public List<AccountBean> select() {
		return selectListWithTimeCheck("account.select");
    }
    
    public int insert(AccountBean bean) {
		return insertWithTimeCheck("account.insert", bean);
	}
}