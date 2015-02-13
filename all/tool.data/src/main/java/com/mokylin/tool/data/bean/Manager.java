package com.mokylin.tool.data.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mokylin.tool.core.bean.IFtl;
import com.mokylin.tool.core.util.FileUtil;

public class Manager extends IFtl {
	public Manager(FtlType ftlType, String destRelativePath, String daoPath) {
		super(ftlType, destRelativePath);
		
		File dir = new File(FileUtil.getFileName(daoPath));
		if (dir.exists()) {
			for (File file : dir.listFiles()) {
				String name = file.getName().substring(0, file.getName().length() - 5);
				names.add(name.substring(0, 1).toLowerCase() + name.substring(1));
			}
		}
	}

	private List<String> names = new ArrayList<>();
	
	@Override
	public HashMap<String, Object> getDataModel() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("names", names);
		return map;
	}

	@Override
	public boolean isRewrite() {
		return true;
	}
}
