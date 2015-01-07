package com.mokylin.game.server.logic.millionluck.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 招财世界记录信息
 */
public class WorldLuckRecordInfo extends Bean {

	private static Logger log = Logger.getLogger(WorldLuckRecordInfo.class);
	
	//百万招财世界纪录
	private Integer maxMillion;
	
	//百万招财纪录玩家名
	private String playerName;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//百万招财世界纪录
			writeInt(buf, this.maxMillion);
			//百万招财纪录玩家名
			writeString(buf, this.playerName);
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
			//百万招财世界纪录
			this.maxMillion = readInt(buf);
			//百万招财纪录玩家名
			this.playerName = readString(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 百万招财世界纪录
	 * @return 
	 */
	public Integer getMaxMillion(){
		return maxMillion;
	}
	
	/**
	 * set 百万招财世界纪录
	 */
	public void setMaxMillion(Integer maxMillion){
		this.maxMillion = maxMillion;
	}
	
	/**
	 * get 百万招财纪录玩家名
	 * @return 
	 */
	public String getPlayerName(){
		return playerName;
	}
	
	/**
	 * set 百万招财纪录玩家名
	 */
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//百万招财世界纪录
		buf.append("maxMillion:" + maxMillion +",");
		//百万招财纪录玩家名
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}