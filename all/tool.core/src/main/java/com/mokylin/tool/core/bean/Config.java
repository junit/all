package com.mokylin.tool.core.bean;

import java.util.HashMap;

public class Config {
	public class Path {
		private String projectPath;
		private String projectName;
		public Path(String projectPath, String projectName) {
			this.projectPath = projectPath;
			this.projectName = projectName;
		}
		public String getProjectPath() {
			return projectPath;
		}
		public void setProjectPath(String projectPath) {
			this.projectPath = projectPath;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
	}
	private HashMap<FtlType, Path> destPath = new HashMap<>();
	public HashMap<FtlType, Path> getDestPath() {
		return destPath;
	}
	public void add(FtlType ftlType, String projectPath, String projectName) {
		destPath.put(ftlType, new Path(projectPath, projectName));
	}
}
