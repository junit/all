package com.mokylin.game.server.logic.soulability.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 前端请求灵魂能力升级消息
 */
public class ReqSoulAbilityUpgradeMessage extends Message{

	private static Logger log = Logger.getLogger(ReqSoulAbilityUpgradeMessage.class);
	
	//角色id
	private Integer characterId;
	//灵魂能力id
	private Integer soulabilityId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.characterId);
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
			//角色id
			this.characterId = readInt(buf);
			//灵魂能力id
			this.soulabilityId = readInt(buf);
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
		return 304201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("characterId:" + characterId +",");
		//灵魂能力id
		buf.append("soulabilityId:" + soulabilityId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}