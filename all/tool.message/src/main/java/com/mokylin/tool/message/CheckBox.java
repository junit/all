package com.mokylin.tool.message;

import javax.swing.JCheckBox;

public class CheckBox extends JCheckBox {
	private static final long serialVersionUID = 5816072097287782585L;
	private FtlConfig config = new FtlConfig();
	
	public CheckBox(String name) {
		super(name);
	}

	public FtlConfig getConfig() {
		return config;
	}

	public void setConfig(FtlConfig config) {
		this.config = config;
	}
}
