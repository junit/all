package com.mokylin.game.robot.logic.record.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 百万招财世界纪录
 */
public class MillionRecord extends Bean {

	private static Logger log = Logger.getLogger(MillionRecord.class);
	
	//玩家名字
	private String playerName;
	
	//招财记录
	private Integer million;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//玩家名字
			writeString(buf, this.playerName);
			//招财记录
			writeInt(buf, this.million);
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
			//玩家名字
			this.playerName = readString(buf);
			//招财记录
			this.million = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 玩家名字
	 * @return 
	 */
	public String getPlayerName(){
		return playerName;
	}
	
	/**
	 * set 玩家名字
	 */
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	
	/**
	 * get 招财记录
	 * @return 
	 */
	public Integer getMillion(){
		return million;
	}
	
	/**
	 * set 招财记录
	 */
	public void setMillion(Integer million){
		this.million = million;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//玩家名字
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		//招财记录
		buf.append("million:" + million +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}