package com.mokylin.tool.message;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.message.bean.Bean;
import com.mokylin.tool.message.bean.Handler;
import com.mokylin.tool.message.bean.Manager;
import com.mokylin.tool.message.bean.Message;

import freemarker.template.Template;

public class Generator {
	public static boolean generate(String xml, FtlConfig config) throws Exception {
		Manager manager = new Manager(config);
		List<IFtl> ftls = parse(xml, config, manager);
		for (IFtl ftl : ftls) {
			generate(ftl, config);
			if (ftl instanceof Handler) {
				manager.add(((Handler) ftl).getId(), ((Handler) ftl).getPkg(), ((Handler) ftl).getName());
			}
		}
		if (config.getHandlerFlag().equals("CS")) { // 后端java
			String prefix = config.getSrcPath() + File.separator + "message" + File.separator;
			generate(manager, config, prefix + "MessageHandlerGroup.java", "handlergroup");
			generate(manager, config, prefix + "MessageFactoryImpl.java", "messagefactory");
		} else { // 前端as
			String prefix = config.getSrcPath() + File.separator + "net" + File.separator;
			generate(manager, config, prefix + "MessagePool.as", "manager");
		}
		manager.update();
		return true;
	}
	
	private static void generate(IFtl ftl, FtlConfig config, String dstFileName, String ftlName) throws Exception {
		Template template = config.getTemplates().get(ftlName);
		File file = new File(dstFileName);
		if (file.exists() && !ftl.isRewrite()) {
			return ;
		}
		if (!file.getParentFile().exists()) {
			mkDir(file.getParentFile());
		}
		file.createNewFile();
		template.process(ftl.getDataModel(), new FileWriterWithEncoding(file, "UTF-8"));
	}
	
	private static void generate(IFtl ftl, FtlConfig config) throws Exception {
		Template template = config.getTemplates().get(ftl.getClass().getSimpleName().toLowerCase());
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

	private static List<IFtl> parse(String xml, FtlConfig config, Manager manager) throws Exception {
		List<IFtl> list = new ArrayList<>();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(xml));
		Element root = doc.getRootElement();
		int indexPrefix = Integer.parseInt(root.attributeValue("id"));
		String pkg = root.attributeValue("package");
		String[] split = pkg.split("\\.");
		pkg = split[split.length - 1];
		
		for (Iterator<?> i = root.elementIterator(); i.hasNext(); ) {
			Element element = (Element)i.next();
			list.addAll(parse(element, indexPrefix, pkg, config));
		}
		return list;
	}

	private static List<IFtl> parse(Element root, int indexPrefix, String pkg, FtlConfig config) throws Exception {
		List<IFtl> ftls = new ArrayList<>();
		if (root.getName().equals("bean")) {
			ftls.add(new Bean(root, pkg, config));
		} else if (root.getName().equals("message")) {
			ftls.add(new Message(root, indexPrefix, pkg, config));
			if (root.attributeValue("type").equalsIgnoreCase(config.getHandlerFlag())) {
				ftls.add(new Handler(root, indexPrefix, pkg, config));
			}
		}
		return ftls;
	}
}
