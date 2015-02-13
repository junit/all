package com.mokylin.tool.ftl.message;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;

import freemarker.template.Template;

public class Manager implements Ftl {
	protected HashMap<String, Object> map = new HashMap<>();
	protected String path;
	protected Template template;

	public Manager(FtlConfig config) throws Exception {
		File file = new File(config.getProjectPath() + File.separator + "message.xml");
		if (file.exists()) {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();

			HashMap<Integer, Detail> details = new HashMap<>();
			for (Iterator<?> i = root.elementIterator("message"); i.hasNext();) {
				Element element = (Element) i.next();
				Detail detail = new Detail(Integer.parseInt(element
						.attributeValue("id")), element.attributeValue("pkg"),
						element.attributeValue("name"));
				details.put(detail.getId(), detail);
			}
			map.put("details", details);
		}
	}
	
	public void add(int id, String pkg, String name) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, Detail> details = (HashMap<Integer, Detail>)map.get("details");
		Detail detail = new Detail(id, pkg, name);
		details.put(detail.getId(), detail);
	}
	
	public void initXml(FtlConfig config) {
		path = config.getProjectPath() + File.separator + "message.xml";
		template = config.getTemplates().get("manager_xml");
	}
	
	public void initCode(FtlConfig config) {
		path = config.getCodePath() + File.separator + "MessageManager." + config.getSuffix();
		template = config.getTemplates().get("manager_code");
	}

	@Override
	public Template getTemplate() {
		return template;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public boolean isRewrite() {
		return true;
	}

	@Override
	public HashMap<String, Object> getDataModel() {
		return map;
	}

	public class Detail {
		private int id;
		private String pkg;
		private String name;

		public Detail(int id, String pkg, String name) {
			this.id = id;
			this.pkg = pkg;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPkg() {
			return pkg;
		}

		public void setPkg(String pkg) {
			this.pkg = pkg;
		}
	}
}
