package com.mokylin.game.robot.logic.login.message;


import com.mokylin.game.core.message.Message;

import io.netty.buffer.ByteBuf;

import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 创建玩家消息
 */
public class ReqCreatePlayerMessage extends Message{

	private static Logger log = Logger.getLogger(ReqCreatePlayerMessage.class);
	
	//角色名字
	private String name;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色名字
			writeString(buf, this.name);
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
			//角色名字
			this.name = readString(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色名字
	 * @return 
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * set 角色名字
	 */
	public void setName(String name){
		this.name = name;
	}
	
	
	@Override
	public int getId() {
		return 100202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色名字
		if(this.name!=null) buf.append("name:" + name.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}