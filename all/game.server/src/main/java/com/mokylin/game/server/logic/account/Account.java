package com.mokylin.game.server.logic.account;

public class Account {
	private String name;
	private int server;
	private long id;
	private transient boolean online;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getServer() {
		return server;
	}
	public void setServer(int server) {
		this.server = server;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	
}
