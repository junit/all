package com.mokylin.tool.ftl;

import java.util.Map;

import freemarker.template.Template;

public interface FtlConfig {
	public Map<String, Template> getTemplates();
	public String getSuffix();
	public String getCodePath();
	public String convertType(String attributeValue);
	public String getProjectPath();
	public String getHandlerType();
}
