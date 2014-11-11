package com.mokylin.tool.core.bean;

import java.util.HashMap;

public abstract class IFtl {
	public IFtl(String path) {
		this.path = path;
	}
	private String path;

	public abstract HashMap<String, Object> getDataModel();

	public abstract boolean isRewrite();
	
	public String getPath() {
		return path;
	}
}
