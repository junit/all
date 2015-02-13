package com.mokylin.tool.ftl.message;

import java.util.HashMap;

import org.dom4j.Element;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.util.FileUtil;

import freemarker.template.Template;

public class Handler implements Ftl {
	protected HashMap<String, Object> map = new HashMap<>();
	protected String path;
	protected Template template;
	private String name;
	private String pkg;
	
	public Handler(Element root, int indexPrefix, String pkg, FtlConfig config) {
		path = FileUtil.getFilePath(config.getCodePath(), pkg, "handler", root.attributeValue("name") + "Handler." + config.getSuffix());
		map.put("name", root.attributeValue("name"));
		map.put("pkg", pkg);
		
		template = config.getTemplates().get("handler");
		
		setId(indexPrefix * 1000 + Integer.parseInt(root.attributeValue("id")));
		
		this.name = root.attributeValue("name");
		this.pkg = pkg;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;

	@Override
	public Template getTemplate() {
		return template;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public boolean isRewrite() {
		return false;
	}

	@Override
	public HashMap<String, Object> getDataModel() {
		return map;
	}

	public String getPkg() {
		return pkg;
	}

	public String getName() {
		return name;
	}
}
