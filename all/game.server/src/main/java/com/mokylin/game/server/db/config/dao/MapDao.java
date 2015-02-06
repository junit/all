package com.mokylin.game.server.db.config.dao;

import java.util.List;

import com.mokylin.game.server.db.BaseDao;
import com.mokylin.game.server.db.config.bean.MapBean;

public class MapDao extends BaseDao<MapBean> {

	public List<MapBean> select() {
		return selectListWithTimeCheck("map.select");
    }
    
    public int insert(MapBean bean) {
		return insertWithTimeCheck("map.insert", bean);
	}
}