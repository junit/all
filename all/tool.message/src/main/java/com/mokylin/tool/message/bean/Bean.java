package com.mokylin.tool.message.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.core.util.FileUtil;
import com.mokylin.tool.message.FtlConfig;

public class Bean extends IFtl {
	public Bean(Element root, String pkg, FtlConfig config) throws Exception {
		super(FileUtil.getFilePath(config.getCommon().getProperty(FtlConfig.PATH), FileUtil.getFilePath("logic", pkg, "message"), root.attributeValue("name"), config.getCommon().getProperty(FtlConfig.SUFFIX)));
		
		setName(root.attributeValue("name"));
		setNote(root.attributeValue("explain"));
		setPkg(pkg);
		
		for (Iterator<?> i = root.elementIterator(); i.hasNext(); ) {
			Element element = (Element)i.next();
			Field field = new Field();
			getFields().add(field);
			
			String clazz = config.getType().getProperty(element.attributeValue("class"));
			if (clazz == null && !element.attributeValue("class").contains(".")) {
				System.err.println("不支持的类型:" + element.attributeValue("class"));
				throw new Exception();
			}
			field.setClazz(clazz == null ? element.attributeValue("class") : clazz);
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

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("pkg", pkg);
		map.put("note", note);
		map.put("name", name);
		map.put("fields", fields);
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
