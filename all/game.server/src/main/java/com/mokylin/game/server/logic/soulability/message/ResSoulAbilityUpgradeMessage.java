package com.mokylin.game.server.logic.soulability.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回前端请求灵魂能力升级结果消息
 */
public class ResSoulAbilityUpgradeMessage extends Message{

	private static Logger log = Logger.getLogger(ResSoulAbilityUpgradeMessage.class);
	
	//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
	private Integer msg;
	//角色id
	private Integer characterId;
	//被激活的灵魂能力Id
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
			//被激活的灵魂能力Id
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
			//被激活的灵魂能力Id
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
	 * get 被激活的灵魂能力Id
	 * @return 
	 */
	public Integer getSoulabilityId(){
		return soulabilityId;
	}
	
	/**
	 * set 被激活的灵魂能力Id
	 */
	public void setSoulabilityId(Integer soulabilityId){
		this.soulabilityId = soulabilityId;
	}
	
	
	@Override
	public int getId() {
		return 304101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
		buf.append("msg:" + msg +",");
		//角色id
		buf.append("characterId:" + characterId +",");
		//被激活的灵魂能力Id
		buf.append("soulabilityId:" + soulabilityId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}