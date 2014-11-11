package com.mokylin.tool.message.bean;

import java.util.HashMap;

import org.dom4j.Element;

import com.mokylin.tool.message.FtlConfig;

public class Message extends Bean {
	public Message(Element root, int indexPrefix, String pkg, FtlConfig config) throws Exception {
		super(root, pkg, config);
		setId(indexPrefix * 1000 + Integer.parseInt(root.attributeValue("id")));
	}

	private int id;

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = super.getDataModel();
		map.put("id", id);
		return map;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean isRewrite() {
		return true;
	}
}
