package com.mokylin.tool.ui.message;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.ftl.message.Bean;
import com.mokylin.tool.ftl.message.Handler;
import com.mokylin.tool.ftl.message.Manager;
import com.mokylin.tool.ftl.message.Message;
import com.mokylin.tool.util.FtlUtil;

public class Generator {
	public static void genServerCode(String file) throws Exception {
		ServerFtlConfig config = new ServerFtlConfig();
		List<Ftl> ftls = new ArrayList<>();
		ftls.addAll(parse(file, config));

		Manager manager = new Manager(config);
		for (Ftl ftl : ftls) {
			FtlUtil.generate(ftl);
			if (ftl instanceof Handler) {
				Handler handler = (Handler) ftl;
				manager.add(handler.getId(), handler.getPkg(), handler.getName());
			}
		}
		FtlUtil.generate(manager);
		manager.update();
	}

	public static void genClientCode(String file) {
		// TODO Auto-generated method stub

	}

	public static void genRobotCode(String file) throws Exception {
		RobotFtlConfig config = new RobotFtlConfig();
		List<Ftl> ftls = new ArrayList<>();
		ftls.addAll(parse(file, config));

		Manager manager = new Manager(config);
		for (Ftl ftl : ftls) {
			FtlUtil.generate(ftl);
			if (ftl instanceof Handler) {
				Handler handler = (Handler) ftl;
				manager.add(handler.getId(), handler.getPkg(), handler.getName());
			}
		}
		FtlUtil.generate(manager);
		manager.update();
	}

	private static List<Ftl> parse(String xml, FtlConfig config) throws Exception {
		List<Ftl> list = new ArrayList<>();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(xml));
		Element root = doc.getRootElement();
		int indexPrefix = Integer.parseInt(root.attributeValue("id"));
		String pkg = root.attributeValue("package");
		String[] split = pkg.split("\\.");
		pkg = split[split.length - 1];

		for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
			Element element = (Element) i.next();
			list.addAll(parse(element, indexPrefix, pkg, config));
		}
		return list;
	}

	private static List<Ftl> parse(Element root, int indexPrefix, String pkg, FtlConfig config) throws Exception {
		List<Ftl> ftls = new ArrayList<>();
		if (root.getName().equals("bean")) {
			ftls.add(new Bean(root, pkg, config));
		} else if (root.getName().equals("message")) {
			ftls.add(new Message(root, indexPrefix, pkg, config));
			if (root.attributeValue("type").equalsIgnoreCase(config.getHandlerType())) {
				ftls.add(new Handler(root, indexPrefix, pkg, config));
			}
		}
		return ftls;
	}
}
