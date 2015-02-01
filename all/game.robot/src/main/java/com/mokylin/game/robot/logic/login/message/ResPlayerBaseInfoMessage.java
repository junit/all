package com.mokylin.game.robot.logic.login.message;


import com.mokylin.game.core.message.Message;

import io.netty.buffer.ByteBuf;

import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 玩家基本信息消息
 */
public class ResPlayerBaseInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerBaseInfoMessage.class);
	
	//玩家基本信息
	private com.mokylin.game.robot.logic.player.bean.PlayerBaseInfo baseInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//玩家基本信息
			writeBean(buf, this.baseInfo);
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
			//玩家基本信息
			this.baseInfo = (com.mokylin.game.robot.logic.player.bean.PlayerBaseInfo)readBean(buf, com.mokylin.game.robot.logic.player.bean.PlayerBaseInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 玩家基本信息
	 * @return 
	 */
	public com.mokylin.game.robot.logic.player.bean.PlayerBaseInfo getBaseInfo(){
		return baseInfo;
	}
	
	/**
	 * set 玩家基本信息
	 */
	public void setBaseInfo(com.mokylin.game.robot.logic.player.bean.PlayerBaseInfo baseInfo){
		this.baseInfo = baseInfo;
	}
	
	
	@Override
	public int getId() {
		return 100103;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//玩家基本信息
		if(this.baseInfo!=null) buf.append("baseInfo:" + baseInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}