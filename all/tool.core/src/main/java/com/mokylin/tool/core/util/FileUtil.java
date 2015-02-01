package com.mokylin.tool.core.util;

import java.io.File;

public class FileUtil {
	public static String getFileName(String path) {
		path.replace("/", File.separator);
		path.replace("\\\\", File.separator);
		return path;
	}
}
