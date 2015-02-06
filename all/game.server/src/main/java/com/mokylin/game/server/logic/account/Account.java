package com.mokylin.game.server.logic.account;

import com.mokylin.game.core.thread.GameObject;
import com.mokylin.game.server.config.Platform;
import com.mokylin.game.server.logic.role.Role;

public class Account extends GameObject {
	private long id;
	private String name;
	private Platform platform;
	private int server;
	private long createTime;

	private transient boolean online;
	private transient Role role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
