package com.mokylin.game.robot.logic.playersync.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 同步的角色信息
 */
public class CharacterSyncInfo extends Bean {

	private static Logger log = Logger.getLogger(CharacterSyncInfo.class);
	
	//角色id
	private Integer characterId;
	
	//角色阶级
	private Integer stageLevel;
	
	//角色战斗力
	private Integer fighting;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.characterId);
			//角色阶级
			writeInt(buf, this.stageLevel);
			//角色战斗力
			writeInt(buf, this.fighting);
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
			this.characterId = readInt(buf);
			//角色阶级
			this.stageLevel = readInt(buf);
			//角色战斗力
			this.fighting = readInt(buf);
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
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 角色id
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
	}
	
	/**
	 * get 角色阶级
	 * @return 
	 */
	public Integer getStageLevel(){
		return stageLevel;
	}
	
	/**
	 * set 角色阶级
	 */
	public void setStageLevel(Integer stageLevel){
		this.stageLevel = stageLevel;
	}
	
	/**
	 * get 角色战斗力
	 * @return 
	 */
	public Integer getFighting(){
		return fighting;
	}
	
	/**
	 * set 角色战斗力
	 */
	public void setFighting(Integer fighting){
		this.fighting = fighting;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("characterId:" + characterId +",");
		//角色阶级
		buf.append("stageLevel:" + stageLevel +",");
		//角色战斗力
		buf.append("fighting:" + fighting +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}