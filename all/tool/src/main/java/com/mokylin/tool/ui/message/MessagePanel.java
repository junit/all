package com.mokylin.tool.ui.message;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

public class MessagePanel {
	private JPanel panel = new JPanel();
	private DefaultListModel<String> model = new DefaultListModel<>();
	private Properties properties = new Properties();

	public MessagePanel(JFrame frame) throws Exception {
		properties.load(new FileReader("config/message/config.properties"));
		
		frame.getContentPane().add(panel);
		panel.setBounds(113, 10, 461, 342);
		panel.setLayout(null);
		
		JList<String> list = new JList<String>();
		list.setModel(model);
		JScrollPane excelList = new JScrollPane();
		excelList.setBounds(0, 0, 348, 342);
		excelList.setViewportView(list);
		panel.add(excelList);
		
		JButton refreshButton = new JButton("刷新");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		refreshButton.setBounds(358, 13, 93, 23);
		panel.add(refreshButton);
		
		JButton excelServerDataButton = new JButton("后端代码");
		excelServerDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				for (String file : list.getSelectedValuesList()) {
					genServerCode(file);
				}
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
			}
		});
		excelServerDataButton.setBounds(358, 46, 93, 23);
		panel.add(excelServerDataButton);
		
		JButton btnNewButton_2 = new JButton("前端代码");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String file : list.getSelectedValuesList()) {
					genClientCode(file);
				}
			}
		});
		btnNewButton_2.setBounds(358, 79, 93, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("机器人代码");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String file : list.getSelectedValuesList()) {
					genRobotCode(file);
				}
			}
		});
		btnNewButton_3.setBounds(358, 112, 93, 23);
		panel.add(btnNewButton_3);
		
		
		
		panel.setVisible(false);
	}

	public void show() {
		refresh();
		panel.setVisible(true);
	}
	
	public void hidden() {
		panel.setVisible(false);
	}
	
	private void refresh() {
		File dir = new File(properties.getProperty("path"));
		for (File file : dir.listFiles()) {
			model.addElement(file.getName());
		}
	}
	
	private void genServerCode(String file) throws Exception {
		ServerFtlConfig config = new ServerFtlConfig();
		List<Ftl> ftls = new ArrayList<>();
		ftls.addAll(parse(file, config));
		
		Manager manager = new Manager(config);
		for (Ftl ftl : ftls) {
			FtlUtil.generate(ftl);
			if (ftl instanceof Handler) {
				Handler handler = (Handler)ftl;
				manager.add(handler.getId(), handler.getPkg(), handler.getName());
			}
		}
		manager.initCode(config);
		FtlUtil.generate(manager);
		manager.initXml(config);
		FtlUtil.generate(manager);
	}
	
	private void genClientCode(String file) {
		// TODO Auto-generated method stub
		
	}
	
	private void genRobotCode(String file) {
		// TODO Auto-generated method stub
		
	}
	
	private List<Ftl> parse(String xml, FtlConfig config) throws Exception {
		List<Ftl> list = new ArrayList<>();
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
