package com.mokylin.tool.message;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FtlConfig {
	public final static String PATH="path";
	public final static String SUFFIX="suffix";
	
	private Properties common;
	private Properties type;
	private HashMap<String, Template> templates;
	
	public Properties getCommon() {
		return common;
	}
	public void setCommon(Properties common) {
		this.common = common;
	}
	public Properties getType() {
		return type;
	}
	public void setType(Properties type) {
		this.type = type;
	}
	public HashMap<String, Template> getTemplates() {
		return templates;
	}
	public void setTemplates(HashMap<String, Template> templates) {
		this.templates = templates;
	}
	
	public void init(File dir) throws Exception {
		for (File file : dir.listFiles()) {
			if (file.getName().equalsIgnoreCase("common.properties")) {
				common = new Properties();
				common.load(new FileInputStream(file));
			} else if (file.getName().equalsIgnoreCase("type.properties")) {
				type = new Properties();
				type.load(new FileInputStream(file));
			} else if (file.getName().equalsIgnoreCase("ftl")) {
				templates = new HashMap<>();
				freemarker.template.Configuration cfg = new freemarker.template.Configuration();
				cfg.setDefaultEncoding("UTF-8");
				cfg.setObjectWrapper(new DefaultObjectWrapper());
				
				cfg.setDirectoryForTemplateLoading(file);
				for (File ftl : file.listFiles()) {
					String[] split = ftl.getName().split("\\.");
					templates.put(split[0], cfg.getTemplate(ftl.getName()));
				}
			}
		}
	}
}
