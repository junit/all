package com.mokylin.tool.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbOpt {
	private static DbOpt instance;
	public static DbOpt getInstance() throws Exception {
		return instance;
	}
	
	public static DbOpt getInstance(String dataUrl, String dataUsr, String dataPwd, String configUrl, String configUsr, String configPwd) throws Exception {
		if (instance == null) {
			instance = new DbOpt(dataUrl, dataUsr, dataPwd, configUrl, configUsr, configPwd);
		}
		return instance;
	}

	private Connection config;
	private Connection data;

	private DbOpt(String dataUrl, String dataUsr, String dataPwd, String configUrl, String configUsr, String configPwd) throws Exception {
		data = init(dataUrl, dataUsr, dataPwd);
		config = init(configUrl, configUsr, configPwd);
	}

	private Connection init(String url, String user, String password) {
		Connection conn;
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			conn = DriverManager.getConnection(url, user, password);

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	public Object[] getDataTables() throws Exception {
		ResultSet tables = data.getMetaData().getTables(null, null, null, new String[] { "TABLE" });
		List<String> list = new ArrayList<>();

		while (tables.next()) {
			list.add(tables.getString(3));
		}

		return list.toArray();
	}

	public Object[] getConfigTables() throws Exception {
		ResultSet tables = config.getMetaData().getTables(null, null, null, new String[] { "TABLE" });
		List<String> list = new ArrayList<>();

		while (tables.next()) {
			list.add(tables.getString(3));
		}

		return list.toArray();
	}

	public Map<String, String> getDataTableMap(String table) throws Exception {
		HashMap<String, String> map = new HashMap<>();
		String sql = new StringBuilder().append("select * from ").append(table).toString();
		Statement statement = data.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int colcount = rsmd.getColumnCount();// 取得全部列数
		for (int i = 1; i <= colcount; i++) {
			map.put(rsmd.getColumnName(i), rsmd.getColumnTypeName(i));
		}
		return map;
	}

	public Map<String, String> getConfigTableMap(String table) throws Exception {
		HashMap<String, String> map = new HashMap<>();
		String sql = new StringBuilder().append("select * from ").append(table).toString();
		Statement statement = config.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int colcount = rsmd.getColumnCount();// 取得全部列数
		for (int i = 1; i <= colcount; i++) {
			map.put(rsmd.getColumnName(i), rsmd.getColumnTypeName(i));
		}
		return map;
	}
}
