package com.mokylin.tool.message;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class RobotMessageIniter {
	public static void main(String[] args) throws Exception {
		try {
			freemarker.template.Configuration cfg = new freemarker.template.Configuration();
			cfg.setDefaultEncoding("UTF-8");
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			cfg.setDirectoryForTemplateLoading(new File("config/test_robot"));

			File file = new File("/home/shell/workspace/Game/src/message.xml");
			if (!file.exists()) {
				return;
			}
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();

			List<IniterTemplate> initers = new ArrayList<>();

			for (Iterator<?> i = root.elementIterator("message"); i.hasNext();) {
				Element element = (Element) i.next();
				IniterTemplate initer = new IniterTemplate();
				initer.setHandlerName(element.attributeValue("handler"));
				initer.setMsgName(element.attributeValue("message"));
				initer.setId(element.attributeValue("id"));
				initer.setName(element.attributeValue("name"));
				String[] split = initer.getHandlerName().split("\\.");
				initer.setShortHandlerName(split[split.length - 1]);
				initers.add(initer);
			}

			for (IniterTemplate initer : initers) {
				File newFile = new File("/home/shell/workspace/Game/test/com/moloong/bleach/robot/initer/" + initer.getShortHandlerName() + "Initer.java");
				if (newFile.exists()) {
					continue;
				}
				HashMap<String, Object> map = new HashMap<>();
				map.put("short_handler", initer.getShortHandlerName());
				map.put("msg", initer.getMsgName());
				newFile.createNewFile();
				
				Template template = cfg.getTemplate("initer.ftl");
				template.process(map, new FileWriterWithEncoding(newFile, "UTF-8"));
			}
			
			File newFile = new File("/home/shell/workspace/Game/test/com/moloong/bleach/robot/RobotThread.java");
			Template template = cfg.getTemplate("thread.ftl");
			HashMap<String, Object> map = new HashMap<>();
			map.put("details", initers);
			template.process(map, new FileWriterWithEncoding(newFile, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
