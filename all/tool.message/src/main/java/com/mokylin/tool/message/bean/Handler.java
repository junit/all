package com.mokylin.tool.message.bean;

import java.util.HashMap;

import org.dom4j.Element;

import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.core.util.FileUtil;
import com.mokylin.tool.message.FtlConfig;

public class Handler extends IFtl {
	public Handler(Element root, int indexPrefix, String pkg, FtlConfig config) {
		super("");
		super.path = FileUtil.getFilePath(config.getSrcPath(), "logic", pkg, "handler", root.attributeValue("name") + this.getClass().getSimpleName() + "." + config.getFileSuffix());
		id = indexPrefix * 1000 + Integer.parseInt(root.attributeValue("id"));
		this.pkg = pkg;
		this.name = root.attributeValue("name");
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
