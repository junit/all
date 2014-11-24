package com.mokylin.tool.ftl.db.config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.util.FileUtil;

import freemarker.template.Template;

public class ContainerPool implements Ftl {
	private HashMap<String, Object> map = new HashMap<>();
	protected String path;
	protected Template template;
	
	public ContainerPool(FtlConfig config) {
		List<String> names = new ArrayList<String>();
		File dir = new File(FileUtil.getFilePath(config.getCodePath(), "db", config.getDbPkg(), "container"));
		if (dir.exists()) {
			for (File file : dir.listFiles()) {
				names.add(file.getName().split(".")[0]);
			}
		}
		
		template = config.getTemplates().get("containerpool");
		path = FileUtil.getFilePath(config.getCodePath(), "db", config.getDbPkg(), "ContainerPool", config.getSuffix());
	}

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
		return true;
	}

	@Override
	public HashMap<String, Object> getDataModel() {
		return map;
	}

}
