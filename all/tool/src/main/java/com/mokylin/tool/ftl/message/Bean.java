package com.mokylin.tool.ftl.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.util.FileUtil;

import freemarker.template.Template;

public class Bean implements Ftl {
	protected HashMap<String, Object> map = new HashMap<>();
	protected String path;
	protected Template template;
	
	public Bean(Element root, String pkg, FtlConfig config) throws Exception {
		path = FileUtil.getFilePath(config.getCodePath(), pkg, "message", root.attributeValue("name") + "." + config.getSuffix());
		
		map.put("pkg", pkg);
		map.put("name", root.attributeValue("name"));
		map.put("note", root.attributeValue("explain"));
		List<Field> fields = new ArrayList<>();
		for (Iterator<?> i = root.elementIterator(); i.hasNext(); ) {
			Element element = (Element)i.next();
			Field field = new Field();
			fields.add(field);
			
			field.setClazz(config.convertType(element.attributeValue("class")));
			if (field.getClazz() == null) {
				System.err.println("不支持的类型:" + element.attributeValue("class"));
				throw new Exception();
			}
			field.setName(element.attributeValue("name"));
			field.setNote(element.attributeValue("explain"));
			if (element.getName().equals("list")) {
				field.setListFlag(1);
			}
		}
		map.put("fields", fields);
		
		template = config.getTemplates().get("bean");
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
