package com.mokylin.tool.util;

import java.io.File;

import org.apache.commons.io.output.FileWriterWithEncoding;

import com.mokylin.tool.ftl.Ftl;

import freemarker.template.Template;

public class FtlUtil {
	public static void generate(Ftl ftl) throws Exception {
		Template template = ftl.getTemplate();
		File file = new File(ftl.getPath());
		if (file.exists() && !ftl.isRewrite()) {
			return ;
		}
		if (!file.getParentFile().exists()) {
			mkDir(file.getParentFile());
		}
		file.createNewFile();
		template.process(ftl.getDataModel(), new FileWriterWithEncoding(file, "UTF-8"));
	}
	
	private static void mkDir(File file) {
		if (file.getParentFile().exists()) {
			file.mkdir();
		} else {
			mkDir(file.getParentFile());
			file.mkdir();
		}
	}
}
