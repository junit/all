package com.mokylin.game.server.logic.equip.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 装备信息
 */
public class EquipInfo extends Bean {

	private static Logger log = Logger.getLogger(EquipInfo.class);
	
	//装备id
	private Integer equipmentId;
	
	//装备等级
	private Integer level;
	
	//装备阶级
	private Integer stage;
	
	//突破次数
	private Integer tupo;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//装备id
			writeInt(buf, this.equipmentId);
			//装备等级
			writeInt(buf, this.level);
			//装备阶级
			writeInt(buf, this.stage);
			//突破次数
			writeInt(buf, this.tupo);
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
			//装备id
			this.equipmentId = readInt(buf);
			//装备等级
			this.level = readInt(buf);
			//装备阶级
			this.stage = readInt(buf);
			//突破次数
			this.tupo = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 装备id
	 * @return 
	 */
	public Integer getEquipmentId(){
		return equipmentId;
	}
	
	/**
	 * set 装备id
	 */
	public void setEquipmentId(Integer equipmentId){
		this.equipmentId = equipmentId;
	}
	
	/**
	 * get 装备等级
	 * @return 
	 */
	public Integer getLevel(){
		return level;
	}
	
	/**
	 * set 装备等级
	 */
	public void setLevel(Integer level){
		this.level = level;
	}
	
	/**
	 * get 装备阶级
	 * @return 
	 */
	public Integer getStage(){
		return stage;
	}
	
	/**
	 * set 装备阶级
	 */
	public void setStage(Integer stage){
		this.stage = stage;
	}
	
	/**
	 * get 突破次数
	 * @return 
	 */
	public Integer getTupo(){
		return tupo;
	}
	
	/**
	 * set 突破次数
	 */
	public void setTupo(Integer tupo){
		this.tupo = tupo;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//装备id
		buf.append("equipmentId:" + equipmentId +",");
		//装备等级
		buf.append("level:" + level +",");
		//装备阶级
		buf.append("stage:" + stage +",");
		//突破次数
		buf.append("tupo:" + tupo +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}