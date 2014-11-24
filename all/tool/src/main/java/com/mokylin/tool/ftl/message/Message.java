package com.mokylin.tool.ftl.message;

import org.dom4j.Element;

import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.util.FileUtil;

public class Message extends Bean {
	public Message(Element root, int indexPrefix, String pkg, FtlConfig config) throws Exception {
		super(root, pkg, config);
		
		path = FileUtil.getFilePath(config.getCodePath(), "logic", pkg, "message", root.attributeValue("name") + "Message." + config.getSuffix());
		int id = indexPrefix * 1000 + Integer.parseInt(root.attributeValue("id"));
		getDataModel().put("id", id);
		template = config.getTemplates().get("message");
	}
}
