package com.mokylin.tool.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public static Connection getConnection(String url) {
		Connection conn;
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 连续数据库
			conn = DriverManager.getConnection(url);

			conn.setAutoCommit(false);
		} catch (Exception e) {
			System.out.println("connect to the Database failed! " + url);
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}
