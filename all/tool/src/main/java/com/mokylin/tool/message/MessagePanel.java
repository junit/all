package com.mokylin.tool.message;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MessagePanel {
	private JPanel panel = new JPanel();
	private DefaultListModel<String> model = new DefaultListModel<>();
	private Properties properties = new Properties();

	public MessagePanel(JFrame frame) throws Exception {
		properties.load(new FileReader("config/message/config.properties"));
		
		frame.getContentPane().add(panel);
		panel.setBounds(113, 10, 461, 342);
		panel.setLayout(null);
		
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
				// TODO
			}
		});
		excelServerDataButton.setBounds(358, 46, 93, 23);
		panel.add(excelServerDataButton);
		
		JButton btnNewButton_2 = new JButton("前端代码");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		btnNewButton_2.setBounds(358, 79, 93, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("机器人代码");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		btnNewButton_3.setBounds(358, 112, 93, 23);
		panel.add(btnNewButton_3);
		
		JList<String> list = new JList<String>();
		list.setModel(model);
		JScrollPane excelList = new JScrollPane();
		excelList.setBounds(0, 0, 348, 342);
		excelList.setViewportView(list);
		panel.add(excelList);
		
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
}
