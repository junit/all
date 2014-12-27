package com.mokylin.tool.message.bean;

import java.util.HashMap;

import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;

public class Manager extends IFtl {
	public Manager(FtlType ftlType, String destRelativePath) {
		super(ftlType, destRelativePath);
	}

	private HashMap<Integer, Detail> details = new HashMap<>();

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("details", details.values());
		return map;
	}

	public HashMap<Integer, Detail> getDetails() {
		return details;
	}

	public void setDetails(HashMap<Integer, Detail> details) {
		this.details = details;
	}
	
	public void add(int id, String pkg, String name) {
		Detail detail = new Detail(id, pkg, name);
		details.put(detail.getId(), detail);
	}

	public class Detail {
		private int id;
		private String pkg;
		private String name;

		public Detail(int id, String pkg, String name) {
			this.id = id;
			this.pkg = pkg;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPkg() {
			return pkg;
		}

		public void setPkg(String pkg) {
			this.pkg = pkg;
		}
	}

	@Override
	public boolean isRewrite() {
		return true;
	}
}
