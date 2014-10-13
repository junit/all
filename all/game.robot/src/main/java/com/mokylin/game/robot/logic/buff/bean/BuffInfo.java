package com.mokylin.game.robot.logic.buff.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * Buff信息
 */
public class BuffInfo extends Bean {

	private static Logger log = Logger.getLogger(BuffInfo.class);
	
	//Buff Id
	private Integer id;
	
	//Buff等级
	private Integer level;
	
	//buff强化系数
	private Integer enhance;
	
	//角色id，0：系统，其他>0：角色id
	private Integer characterId;
	
	//Buff剩余时间（秒）
	private Integer timeLeft;
	
	//Buff剩余次数
	private Integer countLeft;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//Buff Id
			writeInt(buf, this.id);
			//Buff等级
			writeInt(buf, this.level);
			//buff强化系数
			writeInt(buf, this.enhance);
			//角色id，0：系统，其他>0：角色id
			writeInt(buf, this.characterId);
			//Buff剩余时间（秒）
			writeInt(buf, this.timeLeft);
			//Buff剩余次数
			writeInt(buf, this.countLeft);
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
			//Buff Id
			this.id = readInt(buf);
			//Buff等级
			this.level = readInt(buf);
			//buff强化系数
			this.enhance = readInt(buf);
			//角色id，0：系统，其他>0：角色id
			this.characterId = readInt(buf);
			//Buff剩余时间（秒）
			this.timeLeft = readInt(buf);
			//Buff剩余次数
			this.countLeft = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get Buff Id
	 * @return 
	 */
	public Integer getId(){
		return id;
	}
	
	/**
	 * set Buff Id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 * get Buff等级
	 * @return 
	 */
	public Integer getLevel(){
		return level;
	}
	
	/**
	 * set Buff等级
	 */
	public void setLevel(Integer level){
		this.level = level;
	}
	
	/**
	 * get buff强化系数
	 * @return 
	 */
	public Integer getEnhance(){
		return enhance;
	}
	
	/**
	 * set buff强化系数
	 */
	public void setEnhance(Integer enhance){
		this.enhance = enhance;
	}
	
	/**
	 * get 角色id，0：系统，其他>0：角色id
	 * @return 
	 */
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 角色id，0：系统，其他>0：角色id
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
	}
	
	/**
	 * get Buff剩余时间（秒）
	 * @return 
	 */
	public Integer getTimeLeft(){
		return timeLeft;
	}
	
	/**
	 * set Buff剩余时间（秒）
	 */
	public void setTimeLeft(Integer timeLeft){
		this.timeLeft = timeLeft;
	}
	
	/**
	 * get Buff剩余次数
	 * @return 
	 */
	public Integer getCountLeft(){
		return countLeft;
	}
	
	/**
	 * set Buff剩余次数
	 */
	public void setCountLeft(Integer countLeft){
		this.countLeft = countLeft;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//Buff Id
		buf.append("id:" + id +",");
		//Buff等级
		buf.append("level:" + level +",");
		//buff强化系数
		buf.append("enhance:" + enhance +",");
		//角色id，0：系统，其他>0：角色id
		buf.append("characterId:" + characterId +",");
		//Buff剩余时间（秒）
		buf.append("timeLeft:" + timeLeft +",");
		//Buff剩余次数
		buf.append("countLeft:" + countLeft +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}