package com.mokylin.tool.message.bean;

public class Field {
	private String clazz;
	private String name;
	private String note;
	private int listFlag; // 0非list 1为list
	private int importFlag; // 0不用import 1为需要import
	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		String str = clazz;
		if (str.equalsIgnoreCase("int")) {
			str = "Integer";
		} else if (str.equalsIgnoreCase("short")) {
			str = "Short";
		} else if (str.equalsIgnoreCase("long")) {
			str = "Long";
		} else if (str.equalsIgnoreCase("byte")) {
			str = "Byte";
		}
		this.clazz = str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public int getListFlag() {
		return listFlag;
	}

	public void setListFlag(int listFlag) {
		this.listFlag = listFlag;
	}

	public int getImportFlag() {
		return importFlag;
	}

	public void setImportFlag(int importFlag) {
		this.importFlag = importFlag;
	}
}
