package com.mokylin.game.robot.logic.soulability.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回灵魂能力激活结果消息消息
 */
public class ResSoulAbilityActivateMessage extends Message{

	private static Logger log = Logger.getLogger(ResSoulAbilityActivateMessage.class);
	
	//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
	private Integer msg;
	//角色id
	private Integer characterId;
	//武器等级
	private Integer weaponLevel;
	//灵魂能力id
	private Integer soulabilityId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
			writeInt(buf, this.msg);
			//角色id
			writeInt(buf, this.characterId);
			//武器等级
			writeInt(buf, this.weaponLevel);
			//灵魂能力id
			writeInt(buf, this.soulabilityId);
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
			//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
			this.msg = readInt(buf);
			//角色id
			this.characterId = readInt(buf);
			//武器等级
			this.weaponLevel = readInt(buf);
			//灵魂能力id
			this.soulabilityId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
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
	
	/**
	 * get 灵魂能力id
	 * @return 
	 */
	public Integer getSoulabilityId(){
		return soulabilityId;
	}
	
	/**
	 * set 灵魂能力id
	 */
	public void setSoulabilityId(Integer soulabilityId){
		this.soulabilityId = soulabilityId;
	}
	
	
	@Override
	public int getId() {
		return 304102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
		buf.append("msg:" + msg +",");
		//角色id
		buf.append("characterId:" + characterId +",");
		//武器等级
		buf.append("weaponLevel:" + weaponLevel +",");
		//灵魂能力id
		buf.append("soulabilityId:" + soulabilityId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}