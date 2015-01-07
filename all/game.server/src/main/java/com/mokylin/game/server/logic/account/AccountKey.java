package com.mokylin.game.server.logic.account;


public class AccountKey {
	private String name;
	private int server;
	private long id;
	
	public AccountKey(String name, int server) {
		this.name = name;
		this.server = server;
	}
	
	public AccountKey(long id) {
		this.id = id;
	}
	
	
	
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

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof AccountKey)) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		AccountKey key = (AccountKey)obj;
		
		if (key.id == id) {
			return true;
		}
		
		if (key.name.equals(name) && key.server == server) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		if (id != 0) {
			return Long.hashCode(id);
		}
		
		String key = name + "#" + server;
		return key.hashCode();
	}
}
