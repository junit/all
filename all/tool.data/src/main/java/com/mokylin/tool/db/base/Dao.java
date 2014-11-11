package com.mokylin.tool.db.base;

import java.util.HashMap;

import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;

public class Dao extends IFtl {
	public Dao(String table, String type, FtlType ftlType, String destRelativePath) {
		super(ftlType, destRelativePath);
		this.name = table;
		this.type = type;
	}

	private String type;
	private String name;
	
	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("type", type);
		map.put("name", name);
		return map;
	}

	@Override
	public boolean isRewrite() {
		return false;
	}
}
