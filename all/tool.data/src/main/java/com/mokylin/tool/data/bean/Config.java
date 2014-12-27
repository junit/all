package com.mokylin.tool.data.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;

public class Config extends IFtl {
	public Config(String url, String usr, String pwd, FtlType ftlType, String destRelativePath) {
		super(ftlType, destRelativePath);
		this.url = url;
		this.usr = usr;
		this.pwd = pwd;
	}

	private String url;
	private String usr;
	private String pwd;
	private List<String> names = new ArrayList<>();

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("url", url);
		map.put("usr", usr);
		map.put("pwd", pwd);
		map.put("path", getDestRelativePath());
		map.put("names", names);
		return map;
	}

	@Override
	public boolean isRewrite() {
		return true;
	}
}
