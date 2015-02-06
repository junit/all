package com.mokylin.game.server.db.config.bean;

public class MapBean {
	private int max_line;
	private int default_line;
	private int x_len;
	private int y_len;
	private int id;
	
	public int getMax_line(){
		return max_line;
	}
	
	public void setMax_line(int max_line){
		this.max_line = max_line;
	}
	
	public int getDefault_line(){
		return default_line;
	}
	
	public void setDefault_line(int default_line){
		this.default_line = default_line;
	}
	
	public int getX_len(){
		return x_len;
	}
	
	public void setX_len(int x_len){
		this.x_len = x_len;
	}
	
	public int getY_len(){
		return y_len;
	}
	
	public void setY_len(int y_len){
		this.y_len = y_len;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
}