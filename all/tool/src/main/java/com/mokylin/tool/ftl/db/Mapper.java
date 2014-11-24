package com.mokylin.tool.ftl.db;

import com.mokylin.tool.ftl.FtlConfig;
import com.mokylin.tool.ui.database.Table;
import com.mokylin.tool.util.FileUtil;

public class Mapper extends Bean {
	public Mapper(Table table, FtlConfig config) {
		super(table, config);
		path = FileUtil.getFilePath(config.getCodePath(), "db", config.getDbPkg(), "mapper", table.getName() + "Mapper." + config.getSuffix());
		template = config.getTemplates().get("mapper");
	}

	@Override
	public boolean isRewrite() {
		return true;
	}
}
