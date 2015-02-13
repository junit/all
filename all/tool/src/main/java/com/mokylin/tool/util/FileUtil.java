package com.mokylin.tool.util;

import java.io.File;

public class FileUtil {
	public static String getFileName(String path) {
		path.replace("/", File.separator);
		path.replace("\\\\", File.separator);
		return path;
	}
	
	public static String getFilePath(String... params) {
		StringBuilder builder = new StringBuilder();
		for (String param : params) {
			builder.append(param).append(File.separator);
		}
		String string = builder.toString();
		return string.substring(0, string.length() - 1);
	}
	
	
	public static String getFilePath(String projectPath, String pkg, String name, String fileSuffix) {
		StringBuilder builder = new StringBuilder();
		builder.append(projectPath).append(File.separator);
		if (pkg != null && pkg.length() > 0) {
			builder.append(pkg).append(File.separator);
		}
		builder.append(name).append(".").append(fileSuffix);
		return builder.toString();
	}
}
