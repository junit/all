package com.mokylin.game.server.logic.butterfly.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 自己的地狱蝶信息
 */
public class ButterflyInfo extends Bean {

	private static Logger log = Logger.getLogger(ButterflyInfo.class);
	
	//地狱蝶数量
	private Integer butterflyCount;
	
	//使用的角色
	private Integer characterId;
	
	//战斗力
	private Integer fighting;
	
	//cd剩余秒数
	private Integer cdTime;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//地狱蝶数量
			writeInt(buf, this.butterflyCount);
			//使用的角色
			writeInt(buf, this.characterId);
			//战斗力
			writeInt(buf, this.fighting);
			//cd剩余秒数
			writeInt(buf, this.cdTime);
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
			//地狱蝶数量
			this.butterflyCount = readInt(buf);
			//使用的角色
			this.characterId = readInt(buf);
			//战斗力
			this.fighting = readInt(buf);
			//cd剩余秒数
			this.cdTime = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 地狱蝶数量
	 * @return 
	 */
	public Integer getButterflyCount(){
		return butterflyCount;
	}
	
	/**
	 * set 地狱蝶数量
	 */
	public void setButterflyCount(Integer butterflyCount){
		this.butterflyCount = butterflyCount;
	}
	
	/**
	 * get 使用的角色
	 * @return 
	 */
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 使用的角色
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
	}
	
	/**
	 * get 战斗力
	 * @return 
	 */
	public Integer getFighting(){
		return fighting;
	}
	
	/**
	 * set 战斗力
	 */
	public void setFighting(Integer fighting){
		this.fighting = fighting;
	}
	
	/**
	 * get cd剩余秒数
	 * @return 
	 */
	public Integer getCdTime(){
		return cdTime;
	}
	
	/**
	 * set cd剩余秒数
	 */
	public void setCdTime(Integer cdTime){
		this.cdTime = cdTime;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//地狱蝶数量
		buf.append("butterflyCount:" + butterflyCount +",");
		//使用的角色
		buf.append("characterId:" + characterId +",");
		//战斗力
		buf.append("fighting:" + fighting +",");
		//cd剩余秒数
		buf.append("cdTime:" + cdTime +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}