package com.mokylin.tool.data;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mokylin.tool.excel.Field;
import com.mokylin.tool.excel.Main;

public class ExcelOpt {

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		// 配置文件
		InputStreamReader stream = new InputStreamReader(new FileInputStream("config.properties"), "utf-8");
		Properties properties = new Properties();
		properties.load(stream);
		String excelPath = properties.getProperty("excel");

		// 数据库
		String driver = "com.mysql.jdbc.Driver";
		// 加载驱动程序
		Class.forName(driver);

		// 连续数据库
		connection = DriverManager.getConnection(properties.getProperty("url"));
		connection.setAutoCommit(false);

		if (!connection.isClosed())
			System.out.println("Succeeded connecting to the Database!");

		// ui

		frame = new JFrame();
		frame.setBounds(100, 100, 624, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JList<String> list = new JList<>();
		File excelDir = new File(excelPath);
		list.setListData(excelDir.list());
		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(10, 10, 588, 451);
		scrollBar.setViewportView(list);
		frame.getContentPane().add(scrollBar);

		JButton button = new JButton("生成");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String fileName : list.getSelectedValuesList()) {
					try {
						process(excelPath + File.separator + fileName);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		button.setBounds(505, 466, 93, 23);
		frame.getContentPane().add(button);
	}

	private void process(String fileName) throws Exception {
		Workbook wb = WorkbookFactory.create(new File(fileName));
		for (int index = 0; index < wb.getNumberOfSheets(); ++index) {
			Sheet sheet = wb.getSheetAt(index);
			process(sheet);
		}
	}

	private void process(Sheet sheet) throws Exception {
		String table = getTableName(sheet.getRow(0));
		if (table == null) {
			return ;
		}
		String dropSql = "drop table if EXISTS " + table;

		Statement statement = connection.createStatement();
		statement.execute(dropSql);

		List<Field> fields = new ArrayList<>();
		fillName(sheet.getRow(1), fields);
		fillType(sheet.getRow(2), fields);
		fillComment(sheet.getRow(3), fields);

		String createSql = getCreateSql(table, fields);
		statement.execute(createSql);

		int rowIndex = 4;
		Row row = null;
		while ((row = sheet.getRow(rowIndex++)) != null) {
			String insertSql = getInsertSql(table, fields, row);
			statement.execute(insertSql);
		}
		connection.commit();
		JOptionPane.showMessageDialog(null, "操作成功");
	}

	private String getInsertSql(String table, List<Field> fields, Row row) {
		int index = 0;
		for (Field field : fields) {
			field.setValue(row.getCell(index++).getStringCellValue());
		}
		
		String front = "insert into " + table + "(";
		String middle = ") values(";
		String last = ")";
		for (Field field : fields) {
			front += field.getName() + ",";
			middle += "'" + field.getValue() + "'" + ",";
		}
		front.substring(0, front.length() - 2);
		middle.substring(0, front.length() - 2);
		return front + middle + last;
	}

	private String getCreateSql(String table, List<Field> fields) {
		String sql = "create table " + table + "(";
		for (Field field : fields) {
			sql += field.getName() + " " + field.getType() + " COMMENT '" + field.getComment() + "',";
		}
		sql += "PRIMARY KEY(" + fields.get(0).getName() + "))";
		return sql;
	}

	private void fillComment(Row row, List<Field> fields) {
		int index = 0;
		for (Field field : fields) {
			field.setComment(row.getCell(index++).getStringCellValue());
		}
	}

	private void fillType(Row row, List<Field> fields) {
		int index = 0;
		for (Field field : fields) {
			field.setType(row.getCell(index++).getStringCellValue());
		}
	}

	private void fillName(Row row, List<Field> fields) {
		for (Cell cell : row) {
			Field field = new Field();
			fields.add(field);
			field.setName(cell.getStringCellValue());
		}
	}

	private String getTableName(Row row) {
		// 验证是不是需要生成表的sheet
		if (row == null) {
			return null;
		}
		Cell cell = row.getCell(0);
		if (cell == null) {
			return null;
		}
		if (!cell.getStringCellValue().equalsIgnoreCase("table")) {
			return null;
		}
		return row.getCell(1).getStringCellValue();
	}
}
