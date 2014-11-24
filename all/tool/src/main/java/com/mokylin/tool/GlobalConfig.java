package com.mokylin.tool;

import java.io.FileReader;
import java.util.Properties;

public class GlobalConfig {
	private static GlobalConfig instance = new GlobalConfig();

	public static GlobalConfig getInstance() {
		return instance;
	}

	private Properties properties = new Properties();

	private GlobalConfig() {
		try {
			properties.load(new FileReader("config/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Properties getProperties() {
		return properties;
	}
}
