package com.mokylin.tool.message.bean;

import java.util.HashMap;

import org.dom4j.Element;

import com.mokylin.tool.message.FtlConfig;

public class Message extends Bean {
	public Message(Element root, int indexPrefix, String pkg, FtlConfig config) throws Exception {
		super(root, pkg, config);
		setId(indexPrefix * 1000 + Integer.parseInt(root.attributeValue("id")));
		if (root.attributeValue("sign") != null) {
			sign = root.attributeValue("sign");
		}
	}

	private int id;
	private String sign = "";

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = super.getDataModel();
		map.put("id", id);
		map.put("sign", sign);
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
