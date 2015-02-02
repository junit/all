package com.mokylin.tool.message.bean;

import java.util.HashMap;

import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;

public class Handler extends IFtl {
	public Handler(FtlType ftlType, String destRelativePath) {
		super(ftlType, destRelativePath);
	}

	private int id;
	private String pkg;
	private String name;

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pkg", pkg);
		map.put("name", name);
		return map;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isRewrite() {
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
