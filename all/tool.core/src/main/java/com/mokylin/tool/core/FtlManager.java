package com.mokylin.tool.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.output.FileWriterWithEncoding;

import com.mokylin.tool.core.bean.Config;
import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FtlManager {
	private HashMap<FtlType, HashMap<String, Template>> ftl2class2template = new HashMap<>();
	private Config config;

	public Config getConfig() {
		return config;
	}

	public FtlManager(String path, Config config) throws IOException {
		freemarker.template.Configuration cfg = new freemarker.template.Configuration();
		cfg.setDefaultEncoding("UTF-8");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		
		File dir = new File(path);
		for (File ftlDir : dir.listFiles()) {
			cfg.setDirectoryForTemplateLoading(ftlDir);
			FtlType ftlType = FtlType.getFtlType(ftlDir.getName());
			ftl2class2template.put(ftlType, new HashMap<>());
			for (File file : ftlDir.listFiles()) {
				String[] split = file.getName().split("\\.");
				ftl2class2template.get(ftlType).put(split[0], cfg.getTemplate(file.getName()));
			}
		}
		
		this.config = config;
	}

	private void mkDir(File file) {
		if (file.getParentFile().exists()) {
			file.mkdir();
		} else {
			mkDir(file.getParentFile());
			file.mkdir();
		}
	}

	public boolean generate(IFtl ftl) throws Exception {
		HashMap<String, Template> class2template = ftl2class2template.get(ftl.getFtlType());
		if (class2template == null) {
			return false;
		}
		
		String[] split = ftl.getClass().getName().split("\\.");
		Template template = class2template.get(split[split.length - 1].toLowerCase());
		if (template == null) {
			return false;
		}

		File file = new File(ftl.getDestRelativePath());
		if (file.exists() && !ftl.isRewrite()) {
			return true;
		}
		if (!file.getParentFile().exists()) {
			mkDir(file.getParentFile());
		}
		file.createNewFile();
		template.process(ftl.getDataModel(), new FileWriterWithEncoding(file, "UTF-8"));
		return true;
	}
}
