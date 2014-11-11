package com.mokylin.game.server.db.${type}.dao;

import java.util.List;

import com.mokylin.game.server.db.BaseDao;
import com.mokylin.game.server.db.${type}.bean.${name?cap_first}Bean;

public class ${name?cap_first}Dao extends BaseDao<${name?cap_first}Bean> {

	public List<${name?cap_first}Bean> select() {
		return selectListWithTimeCheck("${name}.select");
    }
    
    public int insert(${name?cap_first}Bean bean) {
		return insertWithTimeCheck("${name}.insert", bean);
	}
}