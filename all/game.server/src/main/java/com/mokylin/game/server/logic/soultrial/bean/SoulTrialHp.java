package com.mokylin.game.server.logic.soultrial.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 灵魂试炼角色血量
 */
public class SoulTrialHp extends Bean {

	private static Logger log = Logger.getLogger(SoulTrialHp.class);
	
	//灵魂试炼角色id
	private Integer characterId;
	
	//灵魂试炼角色剩余血量
	private Integer characterHp;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//灵魂试炼角色id
			writeInt(buf, this.characterId);
			//灵魂试炼角色剩余血量
			writeInt(buf, this.characterHp);
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
			//灵魂试炼角色id
			this.characterId = readInt(buf);
			//灵魂试炼角色剩余血量
			this.characterHp = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 灵魂试炼角色id
	 * @return 
	 */
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 灵魂试炼角色id
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
	}
	
	/**
	 * get 灵魂试炼角色剩余血量
	 * @return 
	 */
	public Integer getCharacterHp(){
		return characterHp;
	}
	
	/**
	 * set 灵魂试炼角色剩余血量
	 */
	public void setCharacterHp(Integer characterHp){
		this.characterHp = characterHp;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//灵魂试炼角色id
		buf.append("characterId:" + characterId +",");
		//灵魂试炼角色剩余血量
		buf.append("characterHp:" + characterHp +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}