package com.mokylin.game.robot.logic.destiny.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 宿命对决信息
 */
public class DestinyInfo extends Bean {

	private static Logger log = Logger.getLogger(DestinyInfo.class);
	
	//角色id
	private Integer character;
	
	//可以挑战的难度
	private Integer difficult;
	
	//今日已经成功挑战的次数
	private Integer times;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.character);
			//可以挑战的难度
			writeInt(buf, this.difficult);
			//今日已经成功挑战的次数
			writeInt(buf, this.times);
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
			//角色id
			this.character = readInt(buf);
			//可以挑战的难度
			this.difficult = readInt(buf);
			//今日已经成功挑战的次数
			this.times = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色id
	 * @return 
	 */
	public Integer getCharacter(){
		return character;
	}
	
	/**
	 * set 角色id
	 */
	public void setCharacter(Integer character){
		this.character = character;
	}
	
	/**
	 * get 可以挑战的难度
	 * @return 
	 */
	public Integer getDifficult(){
		return difficult;
	}
	
	/**
	 * set 可以挑战的难度
	 */
	public void setDifficult(Integer difficult){
		this.difficult = difficult;
	}
	
	/**
	 * get 今日已经成功挑战的次数
	 * @return 
	 */
	public Integer getTimes(){
		return times;
	}
	
	/**
	 * set 今日已经成功挑战的次数
	 */
	public void setTimes(Integer times){
		this.times = times;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("character:" + character +",");
		//可以挑战的难度
		buf.append("difficult:" + difficult +",");
		//今日已经成功挑战的次数
		buf.append("times:" + times +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}