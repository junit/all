package com.mokylin.tool.data.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mokylin.tool.core.bean.FtlType;
import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.core.util.FileUtil;

public class Config extends IFtl {
	public Config(String url, String usr, String pwd, FtlType ftlType, String destRelativePath, String path, String type) {
		super(ftlType, destRelativePath);
		this.url = url;
		this.usr = usr;
		this.pwd = pwd;
		this.type = type;
		
		File dir = new File(FileUtil.getFileName(path + File.separator + "src/main/java/com/mokylin/game/server/db/" + type + "/mapper"));
		if (dir.exists()) {
			for (File file : dir.listFiles()) {
				names.add(file.getName());
			}
		}
	}

	private String url;
	private String usr;
	private String pwd;
	private String type;
	private List<String> names = new ArrayList<>();

	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("url", url);
		map.put("usr", usr);
		map.put("pwd", pwd);
		map.put("path", FileUtil.getFileName("src/main/java/com/mokylin/game/server/db/" + type + "/mapper"));
		map.put("names", names);
		return map;
	}

	@Override
	public boolean isRewrite() {
		return true;
	}
}
