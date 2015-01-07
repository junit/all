package com.mokylin.game.server.logic.equip.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 装备升级消息
 */
public class ReqEquipLevelUpMessage extends Message{

	private static Logger log = Logger.getLogger(ReqEquipLevelUpMessage.class);
	
	//角色id
	private Integer characterId;
	//装备id
	private Integer equipmentId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.characterId);
			//装备id
			writeInt(buf, this.equipmentId);
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
			//装备id
			this.equipmentId = readInt(buf);
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
	
	
	@Override
	public int getId() {
		return 103201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("characterId:" + characterId +",");
		//装备id
		buf.append("equipmentId:" + equipmentId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}