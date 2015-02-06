package com.mokylin.game.server.db.data.dao;

import java.util.List;

import com.mokylin.game.server.db.BaseDao;
import com.mokylin.game.server.db.data.bean.RoleBean;

public class RoleDao extends BaseDao<RoleBean> {

	public List<RoleBean> select() {
		return selectListWithTimeCheck("role.select");
    }
	
	public List<RoleBean> selectByAccount(long account) {
		return selectListWithTimeCheck("role.select_by_account", account);
    }
    
    public int insert(RoleBean bean) {
		return insertWithTimeCheck("role.insert", bean);
	}
}