package com.mokylin.tool.message;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.mokylin.tool.core.FtlManager;
import com.mokylin.tool.core.bean.Config;
import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.core.util.FileUtil;
import com.mokylin.tool.message.bean.Bean;
import com.mokylin.tool.message.bean.Field;
import com.mokylin.tool.message.bean.Handler;
import com.mokylin.tool.message.bean.Manager;
import com.mokylin.tool.message.bean.Manager.Detail;
import com.mokylin.tool.message.bean.Message;

public class Generator {
	public Generator(Properties properties) throws IOException {
		Config config = new Config();
		ftlManager = new FtlManager("ftl", config);
		config.getDestPath().put(FtlType.SERVER, properties.getProperty("server_path"));
		config.getDestPath().put(FtlType.ROBOT, properties.getProperty("robot_path"));
		config.getDestPath().put(FtlType.CLIENT, properties.getProperty("client_path"));
	}
	private FtlManager ftlManager;
	
	public boolean generate(FtlType ftlType, String xml) throws Exception {
		String managerXmlPath = ftlManager.getConfig().getDestPath().get(ftlType) + File.separator + "message.xml";
		Manager manager = parseManager(managerXmlPath, ftlType);
		List<IFtl> ftls = parse(xml, ftlType);
		for (IFtl ftl : ftls) {
			ftlManager.generate(ftl);
			if (ftl instanceof Handler) {
				Handler handler = (Handler)ftl;
				Detail detail = manager.getDetails().get(handler.getId());
				if (detail != null && !detail.getName().equalsIgnoreCase(handler.getName())) {
					System.err.println("错误:" + handler.getId() + "[" + handler.getName() + "," + detail.getName() + "]");
					return false;
				}
				manager.add(handler.getId(), handler.getPkg(), handler.getName());
			}
		}
		ftlManager.generate(manager);
		record(managerXmlPath, manager);
		return true;
	}
	
	private void record(String path, Manager manager) throws Exception {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		
		for (Manager.Detail detail : manager.getDetails().values()) {
			Element element = root.addElement("message");
			element.addAttribute("id", String.valueOf(detail.getId()));
			element.addAttribute("pkg", detail.getPkg());
			element.addAttribute("name", detail.getName());
		}
		
		OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");// 设置XML文件的编码格式
		XMLWriter writer = new XMLWriter(new FileWriterWithEncoding(new File(path), "UTF-8"), format);
		writer.write(document);
		writer.close();
	}

	private Manager parseManager(String path, FtlType ftlType) throws Exception {
		String destPath = FileUtil.getDestRelativePath(null, "MessageManager", ftlType, ftlManager);
		Manager manager = new Manager(ftlType, destPath);
		File file = new File(path);
		if (!file.exists()) {
			return manager;
		}
		SAXReader reader = new SAXReader();
		Document doc = reader.read(file);
		Element root = doc.getRootElement();
		
		for (Iterator<?> i = root.elementIterator("message"); i.hasNext(); ) {
			Element element = (Element)i.next();
			manager.add(Integer.parseInt(element.attributeValue("id")), element.attributeValue("pkg"), element.attributeValue("name"));
		}
		return manager;
	}

	private List<IFtl> parse(String xml, FtlType ftlType) throws Exception {
		List<IFtl> list = new ArrayList<>();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(xml));
		Element root = doc.getRootElement();
		int index = Integer.parseInt(root.attributeValue("id"));
		String pkg = root.attributeValue("package");
		String[] split = pkg.split("\\.");
		pkg = split[split.length - 1];
		
		for (Iterator<?> i = root.elementIterator(); i.hasNext(); ) {
			Element element = (Element)i.next();
			add(list, element, index, pkg, ftlType);
		}
		return list;
	}

	private void add(List<IFtl> list, Element root, int index, String pkg, FtlType ftlType) {
		if (root.getName().equals("bean")) {
			Bean bean = new Bean(ftlType, FileUtil.getDestRelativePath("logic" + File.separator + pkg + File.separator + "message", root.attributeValue("name"), ftlType, ftlManager));
			list.add(bean);
			
			bean.setName(root.attributeValue("name"));
			bean.setNote(root.attributeValue("explain"));
			bean.setPkg(pkg);
			
			for (Iterator<?> i = root.elementIterator(); i.hasNext(); ) {
				Element element = (Element)i.next();
				Field field = new Field();
				bean.getFields().add(field);
				
				field.setClazz(element.attributeValue("class"));
				field.setName(element.attributeValue("name"));
				field.setNote(element.attributeValue("explain"));
				if (element.getName().equals("list")) {
					field.setListFlag(1);
				}
				if (!isJavaType(field.getClazz())) {
					field.setImportFlag(1);
				}
				field.setClazz(getNewClazz(field.getClazz(), ftlType));
			}
		} else if (root.getName().equals("message")) {
			Message message = new Message(ftlType, FileUtil.getDestRelativePath("logic" + File.separator + pkg + File.separator + "message", root.attributeValue("name") + "Message", ftlType, ftlManager));
			list.add(message);
			
			message.setName(root.attributeValue("name"));
			message.setNote(root.attributeValue("explain"));
			message.setPkg(pkg);
			message.setId(index * 1000 + Integer.parseInt(root.attributeValue("id")));
			
			for (Iterator<?> i = root.elementIterator(); i.hasNext(); ) {
				Element element = (Element)i.next();
				Field field = new Field();
				message.getFields().add(field);
				
				field.setClazz(element.attributeValue("class"));
				field.setName(element.attributeValue("name"));
				field.setNote(element.attributeValue("explain"));
				if (element.getName().equals("list")) {
					field.setListFlag(1);
				}
				if (!isJavaType(element.attributeValue("class"))) {
					field.setImportFlag(1);
				}
				field.setClazz(getNewClazz(field.getClazz(), ftlType));
			}
			
			if (root.attributeValue("type").equals(getString(ftlType))) {
				Handler handler = new Handler(ftlType, FileUtil.getDestRelativePath("logic" + File.separator + pkg + File.separator + "handler", message.getName() + "Handler", ftlType, ftlManager));
				list.add(handler);
				
				handler.setId(message.getId());
				handler.setName(message.getName());
				handler.setPkg(pkg);
			}
		}
	}

	private String getNewClazz(String clazz, FtlType ftlType) {
		if (ftlType == FtlType.ROBOT) {
			return clazz.replaceAll("game.server", "game.robot");
		} else if (ftlType == FtlType.CLIENT) {
			return clazz.replaceAll("game.server", "game.client");
		}
		return clazz;
	}

	private boolean isJavaType(String className) {
		if (className.contains(".")) {
			return true;
		}
		switch (className) {
		case "byte":
		case "short":
		case "int":
		case "long":
		case "byte[]":
		case "String":
			return true;
		}
		return false;
	}
	
	private Object getString(FtlType ftlType) {
		switch (ftlType) {
		case SERVER: return "CS";
		case ROBOT: return "SC";
		case CLIENT: return "SC";
		}
		return "";
	}
}
