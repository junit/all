package com.mokylin.tool.db.config;

import java.util.HashMap;

import com.mokylin.tool.core.bean.IFtl;

public class Container extends IFtl {
	public Container(String table, FtlType ftlType, String destRelativePath) {
		super(ftlType, destRelativePath);
		this.name = table;
	}

	private String name;

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", name);
		return map;
	}

	@Override
	public boolean isRewrite() {
		return false;
	}
}
