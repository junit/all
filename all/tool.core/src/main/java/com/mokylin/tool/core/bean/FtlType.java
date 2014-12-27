package com.mokylin.tool.core.bean;

public enum FtlType {
	SERVER,
	CLIENT,
	ROBOT;

	public static FtlType getFtlType(String name) {
		if (name.equalsIgnoreCase("server")) {
			return SERVER;
		}
		if (name.equalsIgnoreCase("client")) {
			return CLIENT;
		}
		if (name.equalsIgnoreCase("robot")) {
			return ROBOT;
		}
		return null;
	}
}
