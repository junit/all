package com.mokylin.game.robot.logic.player.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 属性信息
 */
public class AttributeInfo extends Bean {

	private static Logger log = Logger.getLogger(AttributeInfo.class);
	
	//角色id
	private Integer character;
	
	//生命
	private Integer hp;
	
	//灵力
	private Integer mp;
	
	//攻击
	private Integer atk;
	
	//防御
	private Integer def;
	
	//耐力
	private Integer sta;
	
	//暴击
	private Integer crit;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.character);
			//生命
			writeInt(buf, this.hp);
			//灵力
			writeInt(buf, this.mp);
			//攻击
			writeInt(buf, this.atk);
			//防御
			writeInt(buf, this.def);
			//耐力
			writeInt(buf, this.sta);
			//暴击
			writeInt(buf, this.crit);
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
			//生命
			this.hp = readInt(buf);
			//灵力
			this.mp = readInt(buf);
			//攻击
			this.atk = readInt(buf);
			//防御
			this.def = readInt(buf);
			//耐力
			this.sta = readInt(buf);
			//暴击
			this.crit = readInt(buf);
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
	 * get 生命
	 * @return 
	 */
	public Integer getHp(){
		return hp;
	}
	
	/**
	 * set 生命
	 */
	public void setHp(Integer hp){
		this.hp = hp;
	}
	
	/**
	 * get 灵力
	 * @return 
	 */
	public Integer getMp(){
		return mp;
	}
	
	/**
	 * set 灵力
	 */
	public void setMp(Integer mp){
		this.mp = mp;
	}
	
	/**
	 * get 攻击
	 * @return 
	 */
	public Integer getAtk(){
		return atk;
	}
	
	/**
	 * set 攻击
	 */
	public void setAtk(Integer atk){
		this.atk = atk;
	}
	
	/**
	 * get 防御
	 * @return 
	 */
	public Integer getDef(){
		return def;
	}
	
	/**
	 * set 防御
	 */
	public void setDef(Integer def){
		this.def = def;
	}
	
	/**
	 * get 耐力
	 * @return 
	 */
	public Integer getSta(){
		return sta;
	}
	
	/**
	 * set 耐力
	 */
	public void setSta(Integer sta){
		this.sta = sta;
	}
	
	/**
	 * get 暴击
	 * @return 
	 */
	public Integer getCrit(){
		return crit;
	}
	
	/**
	 * set 暴击
	 */
	public void setCrit(Integer crit){
		this.crit = crit;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("character:" + character +",");
		//生命
		buf.append("hp:" + hp +",");
		//灵力
		buf.append("mp:" + mp +",");
		//攻击
		buf.append("atk:" + atk +",");
		//防御
		buf.append("def:" + def +",");
		//耐力
		buf.append("sta:" + sta +",");
		//暴击
		buf.append("crit:" + crit +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}