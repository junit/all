package com.mokylin.tool.message.bean;

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

import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.core.util.FileUtil;
import com.mokylin.tool.message.FtlConfig;

public class Manager extends IFtl {
	public Manager(FtlConfig config) throws Exception {
		super(FileUtil.getFilePath(config.getSrcPath(), "message.xml"));

		try {
			File file = new File(super.getPath());
			if (file.exists()) {
				SAXReader reader = new SAXReader();
				Document doc = reader.read(file);
				Element root = doc.getRootElement();

				for (Iterator<?> i = root.elementIterator("message"); i.hasNext();) {
					Element element = (Element) i.next();
					add(Integer.parseInt(element.attributeValue("id")), element.attributeValue("pkg"), element.attributeValue("name"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private HashMap<Integer, Detail> details = new HashMap<>();

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("details", details.values());
		return map;
	}

	public HashMap<Integer, Detail> getDetails() {
		return details;
	}

	public void setDetails(HashMap<Integer, Detail> details) {
		this.details = details;
	}

	public void add(int id, String pkg, String name) {
		Detail detail = new Detail(id, pkg, name);
		details.put(detail.getId(), detail);
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

	@Override
	public boolean isRewrite() {
		return true;
	}

	public void update() throws Exception {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");

		for (Manager.Detail detail : getDetails().values()) {
			Element element = root.addElement("message");
			element.addAttribute("id", String.valueOf(detail.getId()));
			element.addAttribute("pkg", detail.getPkg());
			element.addAttribute("name", detail.getName());
		}

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");// 设置XML文件的编码格式
		XMLWriter writer = new XMLWriter(new FileWriterWithEncoding(new File(getPath()), "UTF-8"), format);
		writer.write(document);
		writer.close();
	}
}
