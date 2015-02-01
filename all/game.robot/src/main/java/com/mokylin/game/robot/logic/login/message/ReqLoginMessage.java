package com.mokylin.game.robot.logic.login.message;


import com.mokylin.game.core.message.Message;

import io.netty.buffer.ByteBuf;

import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 登陆消息
 */
public class ReqLoginMessage extends Message{

	private static Logger log = Logger.getLogger(ReqLoginMessage.class);
	
	//玩家用户名
	private String name;
	//玩家密码
	private String password;
	//服务器Id
	private Integer serverId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//玩家用户名
			writeString(buf, this.name);
			//玩家密码
			writeString(buf, this.password);
			//服务器Id
			writeInt(buf, this.serverId);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * 读取字节缓存
	 */
	public boolean read(ByteBuf buf){
        try {
			//玩家用户名
			this.name = readString(buf);
			//玩家密码
			this.password = readString(buf);
			//服务器Id
			this.serverId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 玩家用户名
	 * @return 
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * set 玩家用户名
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * get 玩家密码
	 * @return 
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * set 玩家密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * get 服务器Id
	 * @return 
	 */
	public Integer getServerId(){
		return serverId;
	}
	
	/**
	 * set 服务器Id
	 */
	public void setServerId(Integer serverId){
		this.serverId = serverId;
	}
	
	
	@Override
	public int getId() {
		return 100201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//玩家用户名
		if(this.name!=null) buf.append("name:" + name.toString() +",");
		//玩家密码
		if(this.password!=null) buf.append("password:" + password.toString() +",");
		//服务器Id
		buf.append("serverId:" + serverId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}