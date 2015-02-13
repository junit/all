package com.mokylin.tool.ftl;

import java.util.HashMap;

import freemarker.template.Template;

public interface Ftl {
	public Template getTemplate();
	public String getPath();
	public boolean isRewrite();
	public HashMap<String, Object> getDataModel();
}
