package com.mokylin.tool.message;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FtlConfig {
	private String srcPath;
	private HashMap<String, String> types = new HashMap<String, String>();
	private String fileSuffix;
	private String handlerFlag;
	private HashMap<String, Template> templates;
	
	public void init(File dir) throws Exception {
		for (File file : dir.listFiles()) {
			if (file.getName().equalsIgnoreCase("common.properties")) {
				Properties common = new Properties();
				common.load(new FileInputStream(file));
				srcPath = common.getProperty("src_path");
				fileSuffix = common.getProperty("file_suffix");
				handlerFlag = common.getProperty("handler_flag");
				String[] split = common.getProperty("types").split(",");
				types.put("int8", split[0]);
				types.put("int16", split[1]);
				types.put("int32", split[2]);
				types.put("int64", split[3]);
				types.put("string", split[4]);
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

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public HashMap<String, String> getTypes() {
		return types;
	}

	public void setTypes(HashMap<String, String> types) {
		this.types = types;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getHandlerFlag() {
		return handlerFlag;
	}

	public void setHandlerFlag(String handlerFlag) {
		this.handlerFlag = handlerFlag;
	}

	public HashMap<String, Template> getTemplates() {
		return templates;
	}

	public void setTemplates(HashMap<String, Template> templates) {
		this.templates = templates;
	}
}
