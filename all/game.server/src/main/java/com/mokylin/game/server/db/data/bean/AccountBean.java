package com.mokylin.game.server.db.data.bean;

public class AccountBean {
	private int server;
	private long createTime;
	private String name;
	private long id;
	private int platform;
	
	public int getServer(){
		return server;
	}
	
	public void setServer(int server){
		this.server = server;
	}
	
	public long getCreateTime(){
		return createTime;
	}
	
	public void setCreateTime(long createTime){
		this.createTime = createTime;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public int getPlatform(){
		return platform;
	}
	
	public void setPlatform(int platform){
		this.platform = platform;
	}
	
}