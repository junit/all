package com.mokylin.game.server.logic.soulability.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回灵魂能力信息改变消息消息
 */
public class ResSoulAbilityInfoChangeMessage extends Message{

	private static Logger log = Logger.getLogger(ResSoulAbilityInfoChangeMessage.class);
	
	//角色id
	private Integer characterId;
	//武器等级
	private Integer weaponLevel;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.characterId);
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
			//角色id
			this.characterId = readInt(buf);
			//武器等级
			this.weaponLevel = readInt(buf);
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
	public int getId() {
		return 304103;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("characterId:" + characterId +",");
		//武器等级
		buf.append("weaponLevel:" + weaponLevel +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}