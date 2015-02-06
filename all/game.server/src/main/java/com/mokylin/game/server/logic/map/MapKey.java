package com.mokylin.game.server.logic.map;

import com.mokylin.game.server.config.Platform;

public class MapKey {
	private Platform platform;
	private int server;
	private int model;
	private int line;
	public MapKey(Platform platform, int server, int model, int line) {
		this.platform = platform;
		this.server = server;
		this.model = model;
		this.line = line;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public int getServer() {
		return server;
	}
	public void setServer(int server) {
		this.server = server;
	}
	public int getModel() {
		return model;
	}
	public void setModel(int model) {
		this.model = model;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	
}
