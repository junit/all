package com.mokylin.tool.ftl.db;

import java.util.HashMap;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.ui.database.Table;
import com.mokylin.tool.util.FileUtil;

import freemarker.template.Template;

public class Bean implements Ftl {
	protected HashMap<String, Object> map = new HashMap<>();
	protected String path;
	protected Template template;
	
	public Bean(Table table, FtlConfig config) {
		map.put("name", table.getName());
		map.put("fields", table.getFields());
		
		path = FileUtil.getFilePath(config.getCodePath(), "db", config.getDbPkg(), "bean", table.getName() + "Bean." + config.getSuffix());
		template = config.getTemplates().get("bean");
	}

	@Override
	public HashMap<String, Object> getDataModel() {
		return map;
	}

	@Override
	public boolean isRewrite() {
		return true;
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
