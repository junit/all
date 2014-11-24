package com.mokylin.tool.ftl.db.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.util.FileUtil;

import freemarker.template.Template;

public class DaoPool implements Ftl {
	private HashMap<String, Object> map = new HashMap<>();
	protected String path;
	protected Template template;
	
	public DaoPool(FtlConfig config) {
		List<String> names = new ArrayList<String>();
		File dir = new File(FileUtil.getFilePath(config.getCodePath(), "db", config.getDbPkg(), "dao"));
		if (dir.exists()) {
			for (File file : dir.listFiles()) {
				names.add(file.getName().split(".")[0]);
			}
		}
		
		template = config.getTemplates().get("containerpool");
		path = FileUtil.getFilePath(config.getCodePath(), "db", config.getDbPkg(), "DaoPool", config.getSuffix());
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
