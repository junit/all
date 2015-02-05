package com.mokylin.tool.core.util;

import java.io.File;

import com.mokylin.tool.core.FtlManager;
import com.mokylin.tool.core.bean.FtlType;

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
	
	public static String getDestRelativePath(String pkg, String className, FtlType ftlType, FtlManager ftlManager) {
		String fileSuffix = "";
		if (ftlType == FtlType.SERVER || ftlType == FtlType.ROBOT) {
			fileSuffix = "java";
		} else if (ftlType == FtlType.CLIENT) {
			fileSuffix = "as";
		}
		return getDestRelativePath(pkg, className, ftlType, ftlManager, fileSuffix);
	}
	
	public static String getDestRelativePath(String pkg, String className, FtlType ftlType, FtlManager ftlManager, String fileSuffix) {
		String projectPath = ftlManager.getConfig().getDestPath().get(ftlType);
		return getJavaPath(projectPath, pkg, className, fileSuffix);
	}
	
	public static String getJavaPath(String projectPath, String pkg, String name, String fileSuffix) {
		StringBuilder builder = new StringBuilder();
		builder.append(projectPath).append(File.separator);
		if (pkg != null && pkg.length() > 0) {
			builder.append(pkg).append(File.separator);
		}
		builder.append(name).append(".").append(fileSuffix);
		return builder.toString();
	}
}
