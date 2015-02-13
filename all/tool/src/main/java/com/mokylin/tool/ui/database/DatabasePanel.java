package com.mokylin.tool.ui.database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.mokylin.tool.util.DbUtil;

public class DatabasePanel {
	private JPanel panel = new JPanel();
	private DefaultListModel<String> model = new DefaultListModel<>();
	private Properties properties = new Properties();

	public DatabasePanel(JFrame frame) throws Exception {
		properties.load(new FileReader("config/database/config.properties"));
		
		frame.getContentPane().add(panel);
		panel.setBounds(113, 10, 461, 342);
		panel.setLayout(null);

		JList<String> list = new JList<String>();
		list.setModel(model);
		JScrollPane bar = new JScrollPane();
		bar.setBounds(0, 0, 348, 342);
		bar.setViewportView(list);
		panel.add(bar);

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

		panel.setVisible(false);
	}

	public void show() {
		refresh();
		panel.setVisible(true);
	}

	public void hidden() {
		panel.setVisible(false);
	}

	public void refresh() {
		try {
			model.clear();
			Connection con = DbUtil.getConnection(properties.getProperty("url"));
			ResultSet tables = con.getMetaData().getTables(null, null, null, new String[] { "TABLE" });

			while (tables.next()) {
				model.addElement(tables.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
