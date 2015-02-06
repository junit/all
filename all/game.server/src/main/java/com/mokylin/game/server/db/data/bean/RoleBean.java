package com.mokylin.game.server.db.data.bean;

public class RoleBean {
	private byte[] data;
	private long id;
	private long account;
	
	public byte[] getData(){
		return data;
	}
	
	public void setData(byte[] data){
		this.data = data;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getAccount(){
		return account;
	}
	
	public void setAccount(long account){
		this.account = account;
	}
	
}