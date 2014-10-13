package com.mokylin.game.robot.logic.training.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 单个项目训练结果信息
 */
public class TrainingInfo extends Bean {

	private static Logger log = Logger.getLogger(TrainingInfo.class);
	
	//训练项目id
	private Integer trainingId;
	
	//训练的级别（0：队员训练，1：副队长训练，2：队长训练）
	private Integer level;
	
	//当前训练值
	private Integer curValue;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//训练项目id
			writeInt(buf, this.trainingId);
			//训练的级别（0：队员训练，1：副队长训练，2：队长训练）
			writeInt(buf, this.level);
			//当前训练值
			writeInt(buf, this.curValue);
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
			//训练项目id
			this.trainingId = readInt(buf);
			//训练的级别（0：队员训练，1：副队长训练，2：队长训练）
			this.level = readInt(buf);
			//当前训练值
			this.curValue = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 训练项目id
	 * @return 
	 */
	public Integer getTrainingId(){
		return trainingId;
	}
	
	/**
	 * set 训练项目id
	 */
	public void setTrainingId(Integer trainingId){
		this.trainingId = trainingId;
	}
	
	/**
	 * get 训练的级别（0：队员训练，1：副队长训练，2：队长训练）
	 * @return 
	 */
	public Integer getLevel(){
		return level;
	}
	
	/**
	 * set 训练的级别（0：队员训练，1：副队长训练，2：队长训练）
	 */
	public void setLevel(Integer level){
		this.level = level;
	}
	
	/**
	 * get 当前训练值
	 * @return 
	 */
	public Integer getCurValue(){
		return curValue;
	}
	
	/**
	 * set 当前训练值
	 */
	public void setCurValue(Integer curValue){
		this.curValue = curValue;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//训练项目id
		buf.append("trainingId:" + trainingId +",");
		//训练的级别（0：队员训练，1：副队长训练，2：队长训练）
		buf.append("level:" + level +",");
		//当前训练值
		buf.append("curValue:" + curValue +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}