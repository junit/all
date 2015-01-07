package com.mokylin.game.server.logic.record.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 通关世界纪录
 */
public class LevelRecord extends Bean {

	private static Logger log = Logger.getLogger(LevelRecord.class);
	
	//关卡id
	private Integer levelId;
	
	//难度(0,1,2)
	private Integer levelDifficulty;
	
	//玩家名字
	private String playerName;
	
	//时间记录
	private Integer recordTime;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//关卡id
			writeInt(buf, this.levelId);
			//难度(0,1,2)
			writeInt(buf, this.levelDifficulty);
			//玩家名字
			writeString(buf, this.playerName);
			//时间记录
			writeInt(buf, this.recordTime);
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
			//关卡id
			this.levelId = readInt(buf);
			//难度(0,1,2)
			this.levelDifficulty = readInt(buf);
			//玩家名字
			this.playerName = readString(buf);
			//时间记录
			this.recordTime = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 关卡id
	 * @return 
	 */
	public Integer getLevelId(){
		return levelId;
	}
	
	/**
	 * set 关卡id
	 */
	public void setLevelId(Integer levelId){
		this.levelId = levelId;
	}
	
	/**
	 * get 难度(0,1,2)
	 * @return 
	 */
	public Integer getLevelDifficulty(){
		return levelDifficulty;
	}
	
	/**
	 * set 难度(0,1,2)
	 */
	public void setLevelDifficulty(Integer levelDifficulty){
		this.levelDifficulty = levelDifficulty;
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
	 * get 时间记录
	 * @return 
	 */
	public Integer getRecordTime(){
		return recordTime;
	}
	
	/**
	 * set 时间记录
	 */
	public void setRecordTime(Integer recordTime){
		this.recordTime = recordTime;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//关卡id
		buf.append("levelId:" + levelId +",");
		//难度(0,1,2)
		buf.append("levelDifficulty:" + levelDifficulty +",");
		//玩家名字
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		//时间记录
		buf.append("recordTime:" + recordTime +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}