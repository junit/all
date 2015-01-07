package com.mokylin.game.server.logic.soultrial.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 消息
 */
public class ReqStartSoulTrialMessage extends Message{

	private static Logger log = Logger.getLogger(ReqStartSoulTrialMessage.class);
	
	//试炼id
	private Integer trialId;
	//出战角色id
	private Integer characterId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//试炼id
			writeInt(buf, this.trialId);
			//出战角色id
			writeInt(buf, this.characterId);
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
			//试炼id
			this.trialId = readInt(buf);
			//出战角色id
			this.characterId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 试炼id
	 * @return 
	 */
	public Integer getTrialId(){
		return trialId;
	}
	
	/**
	 * set 试炼id
	 */
	public void setTrialId(Integer trialId){
		this.trialId = trialId;
	}
	
	/**
	 * get 出战角色id
	 * @return 
	 */
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 出战角色id
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
	}
	
	
	@Override
	public int getId() {
		return 204201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//试炼id
		buf.append("trialId:" + trialId +",");
		//出战角色id
		buf.append("characterId:" + characterId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}