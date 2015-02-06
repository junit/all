package com.mokylin.tool.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.mokylin.tool.core.FtlManager;
import com.mokylin.tool.core.bean.Config;
import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.core.util.FileUtil;
import com.mokylin.tool.data.bean.Bean;
import com.mokylin.tool.data.bean.Container;
import com.mokylin.tool.data.bean.Dao;
import com.mokylin.tool.data.bean.Manager;
import com.mokylin.tool.data.bean.Mapper;
import com.mokylin.tool.data.bean.Pool;

public class Generator {
	public Generator(Properties properties) throws Exception {
		DbOpt.getInstance(properties);

		Config config = new Config();
		ftlManager = new FtlManager("ftl", config);
		config.getDestPath().put(FtlType.SERVER, properties.getProperty("server_path"));
		config.getDestPath().put(FtlType.ROBOT, properties.getProperty("robot_path"));
		config.getDestPath().put(FtlType.CLIENT, properties.getProperty("client_path"));
	}

	private FtlManager ftlManager;

	public static String getJavaType(String dbType) {
		if (dbType.equals("BLOB"))
			return "byte[]";
		if (dbType.equals("BIGINT"))
			return "long";
		if (dbType.equals("VARCHAR"))
			return "String";
		if (dbType.equals("INT"))
			return "int";
		System.err.println(dbType);
		return "";
	}

	public static String getDbType(String dbType) {
		// if (dbType.equals("BLOB")) return "byte[]";
		// if (dbType.equals("BIGINT")) return "long";
		// if (dbType.equals("VARCHAR")) return "String";
		if (dbType.equals("INT"))
			return "INTEGER";
		return dbType;
	}

	public void generateData(String table, FtlType type) throws Exception {
		Map<String, String> map = DbOpt.getInstance().getDataTableMap(table);
		List<IFtl> list = generate(table, "data", map, type);
		for (IFtl ftl : list) {
			ftlManager.generate(ftl);
		}

		String poolPath = FileUtil.getFilePath(ftlManager.getConfig().getDestPath().get(type), "db", "data", "DaoPool.java");
		String daoPath = FileUtil.getFilePath(ftlManager.getConfig().getDestPath().get(type), "db", "data", "dao");
		ftlManager.generate(new Pool(type, poolPath, daoPath));
		
		String mapperPath = FileUtil.getFilePath(ftlManager.getConfig().getDestPath().get(type), "db", "data", "mapper");
		String configPath = ftlManager.getConfig().getDestPath().get(type).split("src")[0];
		configPath = FileUtil.getFilePath(configPath, "config", "db-data.xml");
		ftlManager.generate(new com.mokylin.tool.data.bean.Config("jdbc:mysql://192.168.1.120:3307/shell_data", "game", "game", type, configPath, mapperPath, "data"));
	}

	public void generateConfig(String table, FtlType type) throws Exception {
		String name = table.substring(0, 1).toUpperCase() + table.substring(1, table.length());
		Map<String, String> map = DbOpt.getInstance().getConfigTableMap(table);
		List<IFtl> list = generate(table, "config", map, type);
		String containerPath = FileUtil.getFilePath(ftlManager.getConfig().getDestPath().get(type), "db", "config", "container", name + "Container.java");
		list.add(new Container(table, type, containerPath));
		for (IFtl ftl : list) {
			ftlManager.generate(ftl);
		}

		String managerPath = FileUtil.getFilePath(ftlManager.getConfig().getDestPath().get(type), "db", "config", "ContainerPool.java");
		String daoPath = FileUtil.getFilePath(ftlManager.getConfig().getDestPath().get(type), "db", "config", "container");
		ftlManager.generate(new Manager(type, managerPath, daoPath));
		String mapperPath = FileUtil.getFilePath(ftlManager.getConfig().getDestPath().get(type), "db", "config", "mapper");
		String configPath = ftlManager.getConfig().getDestPath().get(type).split("src")[0];
		configPath = FileUtil.getFilePath(configPath, "config", "db-config.xml");
		ftlManager.generate(new com.mokylin.tool.data.bean.Config("jdbc:mysql://192.168.1.120:3307/shell_config", "game", "game", type, configPath, mapperPath, "config"));
	}

	public void mkDir(File file) {
		if (file.getParentFile().exists()) {
			file.mkdir();
		} else {
			mkDir(file.getParentFile());
			file.mkdir();
		}
	}

	private List<IFtl> generate(String table, String type, Map<String, String> map, FtlType ftlType) {
		String name = table.substring(0, 1).toUpperCase() + table.substring(1, table.length());
		List<IFtl> list = new ArrayList<>();
		list.add(new Bean(table, type, map, ftlType, FileUtil.getDestRelativePath("db" + File.separator + type + File.separator + "bean", name + "Bean", ftlType, ftlManager)));
		list.add(new Dao(table, type, ftlType, FileUtil.getDestRelativePath("db" + File.separator + type + File.separator + "dao", name + "Dao", ftlType, ftlManager)));
		list.add(new Mapper(table, type, map, ftlType, FileUtil.getDestRelativePath("db" + File.separator + type + File.separator + "mapper", name + "Mapper", ftlType, ftlManager, "xml")));
		return list;
	}
}
