package com.mokylin.tool.ui.message;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.mokylin.tool.GlobalConfig;
import com.mokylin.tool.ftl.FtlConfig;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class ServerFtlConfig implements FtlConfig {
	public ServerFtlConfig() throws Exception {
		File file = new File("config/message/server/ftl");
		
		freemarker.template.Configuration cfg = new freemarker.template.Configuration();
		cfg.setDefaultEncoding("UTF-8");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setDirectoryForTemplateLoading(file);
		for (File ftl : file.listFiles()) {
			String[] split = ftl.getName().split("\\.");
			templates.put(split[0], cfg.getTemplate(ftl.getName()));
		}
	}
	
	Map<String, Template> templates = new HashMap<>();

	@Override
	public Map<String, Template> getTemplates() {
		return templates;
	}

	@Override
	public String getSuffix() {
		return "java";
	}

	@Override
	public String getCodePath() {
		return GlobalConfig.getInstance().getProperties().getProperty("server_code_path");
	}

	@Override
	public String convertType(String xmlType) {
		if (xmlType.equals("int8")) return "Byte";
		if (xmlType.equals("int16")) return "Short";
		if (xmlType.equals("int32")) return "Integer";
		if (xmlType.equals("int64")) return "Long";
		if (xmlType.equals("string")) return "String";
		return xmlType;
	}

	@Override
	public String getProjectPath() {
		return GlobalConfig.getInstance().getProperties().getProperty("server_project_path");
	}

	@Override
	public String getHandlerType() {
		return "CS";
	}

	@Override
	public String getDbPkg() {
		return null;
	}

	@Override
	public String getDbConfigFile() {
		return null;
	}

}
