package com.mokylin.tool.ftl.db.config;

import java.util.HashMap;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.ui.database.Table;
import com.mokylin.tool.util.FileUtil;

import freemarker.template.Template;

public class Container implements Ftl {
	protected String path;
	protected Template template;
	public Container(Table table, FtlConfig config) {
		this.name = table.getName();
		template = config.getTemplates().get("container");
		path = FileUtil.getFilePath(config.getCodePath(), "db", config.getDbPkg(), "container", table.getName() + "Container." + config.getSuffix());
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

	@Override
	public Template getTemplate() {
		return template;
	}

	@Override
	public String getPath() {
		return path;
	}
}
