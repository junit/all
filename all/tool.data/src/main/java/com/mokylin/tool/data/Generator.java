package com.mokylin.tool.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mokylin.tool.core.FtlManager;
import com.mokylin.tool.core.bean.Config;
import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.data.bean.Bean;
import com.mokylin.tool.data.bean.Container;
import com.mokylin.tool.data.bean.Dao;
import com.mokylin.tool.data.bean.Manager;
import com.mokylin.tool.data.bean.Mapper;

public class Generator {
	public Generator() throws Exception {
		// TODO 配置直接写这里来
		String dataUrl = "jdbc:mysql://127.0.0.1/bleach_game";
		String dataUsr = "game";
		String dataPwd = "game";
		String configUrl = "jdbc:mysql://127.0.0.1/bleach_data";
		String configUsr = "game";
		String configPwd = "game";
		DbOpt.getInstance(dataUrl, dataUsr, dataPwd, configUrl, configUsr, configPwd);
		
		Config config = new Config();
		ftlManager = new FtlManager("/home/shell/git/all/all/tool.data/ftl", config);
		config.add(FtlType.SERVER, "/home/shell/git/all/all/game.server", "game/server");
		config.add(FtlType.ROBOT, "/home/shell/git/all/all/game.robot", "game/robot");
		config.add(FtlType.CLIENT, "/home/shell/git/all/all/res/message/client", "");
	}
	private FtlManager ftlManager;
	
	public static String getJavaType(String dbType) {
		if (dbType.equals("BLOB")) return "byte[]";
		if (dbType.equals("BIGINT")) return "long";
		if (dbType.equals("VARCHAR")) return "String";
		if (dbType.equals("INT")) return "int";
		System.err.println(dbType);
		return "";
	}
	
	public static String getDbType(String dbType) {
//		if (dbType.equals("BLOB")) return "byte[]";
//		if (dbType.equals("BIGINT")) return "long";
//		if (dbType.equals("VARCHAR")) return "String";
		if (dbType.equals("INT")) return "INTEGER";
		return dbType;
	}

	public void generateData(String table, FtlType type) throws Exception {
		Map<String, String> map = DbOpt.getInstance().getDataTableMap(table);
		List<IFtl> list = generate(table, "data", map, type);
		for (IFtl ftl : list) {
			ftlManager.generate(ftl);
		}
		
		ftlManager.generate(new com.mokylin.tool.data.bean.Config("url", "usr", "pwd", type, "config/db-data.xml"));
	}

	public void generateConfig(String table, FtlType type) throws Exception {
		Map<String, String> map = DbOpt.getInstance().getConfigTableMap(table);
		List<IFtl> list = generate(table, "config", map, type);
		list.add(new Container(table, type, getDestRelativePath("config", table, Container.class.getName(), type)));
		for (IFtl ftl : list) {
			ftlManager.generate(ftl);
		}
		
		ftlManager.generate(new Manager(type, "src/main/java/com/mokylin/game/server/db/config/DbConfigManager.java", ftlManager.getConfig().getDestPath().get(type).getProjectPath()));
		ftlManager.generate(new com.mokylin.tool.data.bean.Config("url", "usr", "pwd", type, "config/db-config.xml"));
	}

	public void mkDir(File file) {
		if (file.getParentFile().exists()) {
			file.mkdir();
		} else {
			mkDir(file.getParentFile());
			file.mkdir();
		}
	}
	
	
	private String getDestRelativePath(String type, String table, String clazz, FtlType ftlType) {
		String[] split = clazz.split("\\.");
		String name = split[split.length - 1].toLowerCase();
		StringBuilder builder = new StringBuilder();
		builder.append("src/main/java/com/mokylin").append(File.separator);
		builder.append(ftlManager.getConfig().getDestPath().get(ftlType).getProjectName()).append(File.separator);
		builder.append("db").append(File.separator);
		builder.append(type).append(File.separator);
		builder.append(name).append(File.separator);
		builder.append(table.substring(0, 1).toUpperCase());
		builder.append(table.substring(1));
		builder.append(name.substring(0, 1).toUpperCase()).append(name.substring(1));
		if (clazz.endsWith("Mapper")) {
			builder.append(".xml");
		} else if (ftlType == FtlType.SERVER || ftlType == FtlType.ROBOT) {
			builder.append(".java");
		} else if (ftlType == FtlType.CLIENT) {
			builder.append(".as");
		}
		return builder.toString();
	}
	
	private List<IFtl> generate(String table, String type, Map<String, String> map, FtlType ftlType){
		List<IFtl> list = new ArrayList<>();
		list.add(new Bean(table, type, map, ftlType, getDestRelativePath(type, table, Bean.class.getName(), ftlType)));
		list.add(new Dao(table, type, ftlType, getDestRelativePath(type, table, Dao.class.getName(), ftlType)));
		list.add(new Mapper(table, type, map, ftlType, getDestRelativePath(type, table, Mapper.class.getName(), ftlType)));
		return list;
	}
}
