package com.mokylin.tool.data.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.data.Generator;

public class Mapper extends IFtl {
	public Mapper(String table, String type, Map<String, String> map, FtlType ftlType, String destRelativePath) {
		super(ftlType, destRelativePath);
		
		this.type = type;
		this.name = table;

		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			Field field = new Field();
			fields.add(field);
			field.setName(entry.getKey());
			field.setDbType(Generator.getDbType(entry.getValue()));
			field.setClazz(Generator.getJavaType(entry.getValue()));
		}
	}

	private String type;
	private String name;
	private List<Field> fields = new ArrayList<>();

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("type", type);
		map.put("name", name);
		map.put("fields", fields);
		return map;
	}

	@Override
	public boolean isRewrite() {
		return true;
	}
}
