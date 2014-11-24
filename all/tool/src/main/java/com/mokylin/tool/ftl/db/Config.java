package com.mokylin.tool.ftl.db;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.util.FileUtil;

import freemarker.template.Template;

public class Config implements Ftl {
	private HashMap<String, Object> map = new HashMap<>();
	protected String path;
	protected Template template;
	
	public Config(String url, String usr, String pwd, FtlConfig config) {
		String mapperPath = FileUtil.getFilePath(config.getCodePath(), "db", config.getDbPkg(), "mapper");
		map.put("url", url);
		map.put("usr", usr);
		map.put("pwd", pwd);
		map.put("path", mapperPath);
		List<String> names = new ArrayList<>();
		map.put("names", names);
		
		File dir = new File(FileUtil.getFileName(mapperPath));
		if (dir.exists()) {
			for (File file : dir.listFiles()) {
				names.add(file.getName());
			}
		}
		
		path = FileUtil.getFilePath(config.getProjectPath(), "config", config.getDbConfigFile());
		template = config.getTemplates().get("config");
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
