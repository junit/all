package com.mokylin.game.server.config;

public class ServerConfigKey {
	private Platform platform;
	private int server;
	
	public ServerConfigKey(Platform platform, int server) {
		this.platform = platform;
		this.server = server;
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
	
	@Override
	public int hashCode() {
		return platform.getValue() << 20 | server;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ServerConfigKey) {
			ServerConfigKey key = (ServerConfigKey)obj;
			return key.platform == this.platform && key.server == this.server;
		}
		return false;
	}
}
