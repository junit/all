package com.mokylin.tool.ftl.message;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.mokylin.tool.ftl.Ftl;
import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.util.FileUtil;

import freemarker.template.Template;

public class Manager implements Ftl {
	protected String path;
	protected Template template;
	HashMap<Integer, Detail> details = new HashMap<>();
	private FtlConfig config;

	public Manager(FtlConfig config) throws Exception {
		this.config = config;
		File file = new File(config.getProjectPath() + File.separator + "message.xml");
		if (file.exists()) {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(file);
			Element root = doc.getRootElement();

			
			for (Iterator<?> i = root.elementIterator("message"); i.hasNext();) {
				Element element = (Element) i.next();
				Detail detail = new Detail(Integer.parseInt(element
						.attributeValue("id")), element.attributeValue("pkg"),
						element.attributeValue("name"));
				details.put(detail.getId(), detail);
			}
			
		}
		
		path = config.getCodePath() + File.separator + "MessageManager." + config.getSuffix();
		template = config.getTemplates().get("manager");
	}
	
	public void add(int id, String pkg, String name) {
		Detail detail = new Detail(id, pkg, name);
		details.put(detail.getId(), detail);
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
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("details", details.values());
		return map;
	}
	
	public void update() throws Exception {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		
		for (Manager.Detail detail : details.values()) {
			Element element = root.addElement("message");
			element.addAttribute("id", String.valueOf(detail.getId()));
			element.addAttribute("pkg", detail.getPkg());
			element.addAttribute("name", detail.getName());
		}
		
		OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");// 设置XML文件的编码格式
		XMLWriter writer = new XMLWriter(new FileWriterWithEncoding(new File(FileUtil.getFilePath(config.getProjectPath(), "message.xml")), "UTF-8"), format);
		writer.write(document);
		writer.close();
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
