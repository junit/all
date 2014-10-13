package com.mokylin.game.robot.logic.achievement.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 成就信息
 */
public class AchievementInfo extends Bean {

	private static Logger log = Logger.getLogger(AchievementInfo.class);
	
	//成就Id
	private Integer achieveId;
	
	//进度值
	private Integer value;
	
	//状态，0-未完成，1-已完成，2-已领奖
	private Integer status;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//成就Id
			writeInt(buf, this.achieveId);
			//进度值
			writeInt(buf, this.value);
			//状态，0-未完成，1-已完成，2-已领奖
			writeInt(buf, this.status);
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
			//成就Id
			this.achieveId = readInt(buf);
			//进度值
			this.value = readInt(buf);
			//状态，0-未完成，1-已完成，2-已领奖
			this.status = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 成就Id
	 * @return 
	 */
	public Integer getAchieveId(){
		return achieveId;
	}
	
	/**
	 * set 成就Id
	 */
	public void setAchieveId(Integer achieveId){
		this.achieveId = achieveId;
	}
	
	/**
	 * get 进度值
	 * @return 
	 */
	public Integer getValue(){
		return value;
	}
	
	/**
	 * set 进度值
	 */
	public void setValue(Integer value){
		this.value = value;
	}
	
	/**
	 * get 状态，0-未完成，1-已完成，2-已领奖
	 * @return 
	 */
	public Integer getStatus(){
		return status;
	}
	
	/**
	 * set 状态，0-未完成，1-已完成，2-已领奖
	 */
	public void setStatus(Integer status){
		this.status = status;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//成就Id
		buf.append("achieveId:" + achieveId +",");
		//进度值
		buf.append("value:" + value +",");
		//状态，0-未完成，1-已完成，2-已领奖
		buf.append("status:" + status +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}