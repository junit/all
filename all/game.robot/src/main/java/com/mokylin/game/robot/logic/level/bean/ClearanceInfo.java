package com.mokylin.game.robot.logic.level.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 通关信息
 */
public class ClearanceInfo extends Bean {

	private static Logger log = Logger.getLogger(ClearanceInfo.class);
	
	//关卡Id
	private Integer levelId;
	
	//难度（0：普通，1：困难，2：死神）
	private Integer difficulty;
	
	//通关时长（秒）
	private Integer duration;
	
	//通关评价
	private Integer clearanceEvaluation;
	
	//通关时间（毫秒）
	private Long clearanceTime;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//关卡Id
			writeInt(buf, this.levelId);
			//难度（0：普通，1：困难，2：死神）
			writeInt(buf, this.difficulty);
			//通关时长（秒）
			writeInt(buf, this.duration);
			//通关评价
			writeInt(buf, this.clearanceEvaluation);
			//通关时间（毫秒）
			writeLong(buf, this.clearanceTime);
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
			//关卡Id
			this.levelId = readInt(buf);
			//难度（0：普通，1：困难，2：死神）
			this.difficulty = readInt(buf);
			//通关时长（秒）
			this.duration = readInt(buf);
			//通关评价
			this.clearanceEvaluation = readInt(buf);
			//通关时间（毫秒）
			this.clearanceTime = readLong(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 关卡Id
	 * @return 
	 */
	public Integer getLevelId(){
		return levelId;
	}
	
	/**
	 * set 关卡Id
	 */
	public void setLevelId(Integer levelId){
		this.levelId = levelId;
	}
	
	/**
	 * get 难度（0：普通，1：困难，2：死神）
	 * @return 
	 */
	public Integer getDifficulty(){
		return difficulty;
	}
	
	/**
	 * set 难度（0：普通，1：困难，2：死神）
	 */
	public void setDifficulty(Integer difficulty){
		this.difficulty = difficulty;
	}
	
	/**
	 * get 通关时长（秒）
	 * @return 
	 */
	public Integer getDuration(){
		return duration;
	}
	
	/**
	 * set 通关时长（秒）
	 */
	public void setDuration(Integer duration){
		this.duration = duration;
	}
	
	/**
	 * get 通关评价
	 * @return 
	 */
	public Integer getClearanceEvaluation(){
		return clearanceEvaluation;
	}
	
	/**
	 * set 通关评价
	 */
	public void setClearanceEvaluation(Integer clearanceEvaluation){
		this.clearanceEvaluation = clearanceEvaluation;
	}
	
	/**
	 * get 通关时间（毫秒）
	 * @return 
	 */
	public Long getClearanceTime(){
		return clearanceTime;
	}
	
	/**
	 * set 通关时间（毫秒）
	 */
	public void setClearanceTime(Long clearanceTime){
		this.clearanceTime = clearanceTime;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//关卡Id
		buf.append("levelId:" + levelId +",");
		//难度（0：普通，1：困难，2：死神）
		buf.append("difficulty:" + difficulty +",");
		//通关时长（秒）
		buf.append("duration:" + duration +",");
		//通关评价
		buf.append("clearanceEvaluation:" + clearanceEvaluation +",");
		//通关时间（毫秒）
		buf.append("clearanceTime:" + clearanceTime +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}