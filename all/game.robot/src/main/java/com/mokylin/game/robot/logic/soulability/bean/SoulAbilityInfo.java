package com.mokylin.game.robot.logic.soulability.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 灵魂能力信息
 */
public class SoulAbilityInfo extends Bean {

	private static Logger log = Logger.getLogger(SoulAbilityInfo.class);
	
	//灵魂能力id
	private Integer id;
	
	//灵魂能力等级
	private Integer soulAbilityLevel;
	
	//武器等级
	private Integer weaponLevel;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//灵魂能力id
			writeInt(buf, this.id);
			//灵魂能力等级
			writeInt(buf, this.soulAbilityLevel);
			//武器等级
			writeInt(buf, this.weaponLevel);
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
			//灵魂能力id
			this.id = readInt(buf);
			//灵魂能力等级
			this.soulAbilityLevel = readInt(buf);
			//武器等级
			this.weaponLevel = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 灵魂能力id
	 * @return 
	 */
	public Integer getId(){
		return id;
	}
	
	/**
	 * set 灵魂能力id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 * get 灵魂能力等级
	 * @return 
	 */
	public Integer getSoulAbilityLevel(){
		return soulAbilityLevel;
	}
	
	/**
	 * set 灵魂能力等级
	 */
	public void setSoulAbilityLevel(Integer soulAbilityLevel){
		this.soulAbilityLevel = soulAbilityLevel;
	}
	
	/**
	 * get 武器等级
	 * @return 
	 */
	public Integer getWeaponLevel(){
		return weaponLevel;
	}
	
	/**
	 * set 武器等级
	 */
	public void setWeaponLevel(Integer weaponLevel){
		this.weaponLevel = weaponLevel;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//灵魂能力id
		buf.append("id:" + id +",");
		//灵魂能力等级
		buf.append("soulAbilityLevel:" + soulAbilityLevel +",");
		//武器等级
		buf.append("weaponLevel:" + weaponLevel +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}