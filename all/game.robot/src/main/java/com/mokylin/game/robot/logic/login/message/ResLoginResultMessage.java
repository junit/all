package com.mokylin.game.robot.logic.login.message;


import com.mokylin.game.core.message.Message;

import io.netty.buffer.ByteBuf;

import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 登陆成功消息
 */
public class ResLoginResultMessage extends Message{

	private static Logger log = Logger.getLogger(ResLoginResultMessage.class);
	
	//0-成功  1-服务器未开启 2-用户名密码错 等
	private Integer isSuccess;
	//0-无玩家信息 1-有玩家信息
	private Integer havePlayer;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0-成功  1-服务器未开启 2-用户名密码错 等
			writeInt(buf, this.isSuccess);
			//0-无玩家信息 1-有玩家信息
			writeInt(buf, this.havePlayer);
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
			//0-成功  1-服务器未开启 2-用户名密码错 等
			this.isSuccess = readInt(buf);
			//0-无玩家信息 1-有玩家信息
			this.havePlayer = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0-成功  1-服务器未开启 2-用户名密码错 等
	 * @return 
	 */
	public Integer getIsSuccess(){
		return isSuccess;
	}
	
	/**
	 * set 0-成功  1-服务器未开启 2-用户名密码错 等
	 */
	public void setIsSuccess(Integer isSuccess){
		this.isSuccess = isSuccess;
	}
	
	/**
	 * get 0-无玩家信息 1-有玩家信息
	 * @return 
	 */
	public Integer getHavePlayer(){
		return havePlayer;
	}
	
	/**
	 * set 0-无玩家信息 1-有玩家信息
	 */
	public void setHavePlayer(Integer havePlayer){
		this.havePlayer = havePlayer;
	}
	
	
	@Override
	public int getId() {
		return 100101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0-成功  1-服务器未开启 2-用户名密码错 等
		buf.append("isSuccess:" + isSuccess +",");
		//0-无玩家信息 1-有玩家信息
		buf.append("havePlayer:" + havePlayer +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}