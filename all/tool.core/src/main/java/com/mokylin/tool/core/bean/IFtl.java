package com.mokylin.tool.core.bean;

import java.util.HashMap;

public abstract class IFtl {
	public IFtl(FtlType ftlType, String destRelativePath) {
		this.ftlType = ftlType;
		this.destRelativePath = destRelativePath;
	}
	private FtlType ftlType;
	private String destRelativePath;

	public abstract HashMap<String, Object> getDataModel();

	public abstract boolean isRewrite();

	public FtlType getFtlType() {
		return ftlType;
	}

	public String getDestRelativePath() {
		return destRelativePath;
	}
}
