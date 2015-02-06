package com.mokylin.tool.data;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOpt {
	private Connection connection;
	
	public ExcelOpt() throws Exception {
		connection = DbOpt.getInstance().getConfig();
	}

	public void process(String fileName) throws Exception {
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

class Field {
	private String name;
	private String type;
	private String comment;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}