package com.mokylin.tool.message.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;

public class Bean extends IFtl {
	public Bean(FtlType ftlType, String destRelativePath) {
		super(ftlType, destRelativePath);
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
