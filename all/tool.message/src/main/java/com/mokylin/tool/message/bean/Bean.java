package com.mokylin.tool.message.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.dom4j.Element;

import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.core.util.FileUtil;
import com.mokylin.tool.message.FtlConfig;

public class Bean extends IFtl {
	public Bean(Element root, String pkg, FtlConfig config) throws Exception {
		super("");
		String sname = getClass().getSimpleName().equals("Bean") ? "" : getClass().getSimpleName();
		super.path = FileUtil.getFilePath(config.getSrcPath(), "logic", pkg, "message", root.attributeValue("name") + sname + "." + config.getFileSuffix());
		
		setName(root.attributeValue("name"));
		setNote(root.attributeValue("explain"));
		setPkg(pkg);
		
		for (Iterator<?> i = root.elementIterator(); i.hasNext(); ) {
			Element element = (Element)i.next();
			Field field = new Field();
			getFields().add(field);
			
			String clazz = element.attributeValue("class");
			if (config.getTypes().containsKey(clazz)) {
				clazz = config.getTypes().get(clazz);
			} else if (clazz.contains(".")) {
				imports.add(clazz);
				String[] split = clazz.split("\\.");
				clazz = split[split.length - 1];
			}
			field.setClazz(clazz);
			field.setName(element.attributeValue("name"));
			field.setNote(element.attributeValue("explain"));
			if (element.getName().equals("list")) {
				field.setListFlag(1);
			}
		}
	}

	private String pkg;
	private String note;
	private String name;
	private List<Field> fields = new ArrayList<>();
	private Set<String> imports = new HashSet<>();

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pkg", pkg);
		map.put("note", note);
		map.put("name", name);
		map.put("fields", fields);
		map.put("imports", imports);
		return map;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	@Override
	public boolean isRewrite() {
		return true;
	}

}
