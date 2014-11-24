package com.mokylin.tool.ui.database;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private String name;
	private List<Field> fields = new ArrayList<>();
	
	
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


	public class Field {
		private String clazz;
		private String name;
		private String dbType;
		public String getClazz() {
			return clazz;
		}
		public void setClazz(String clazz) {
			this.clazz = clazz;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDbType() {
			return dbType;
		}
		public void setDbType(String dbType) {
			this.dbType = dbType;
		}
	}
}
