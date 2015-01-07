package com.mokylin.game.server.logic.character.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 角色进阶回复消息
 */
public class ResCharacterStageUpMessage extends Message{

	private static Logger log = Logger.getLogger(ResCharacterStageUpMessage.class);
	
	//角色进阶结果(0:成功，1：元宝不足，
	private Byte result;
	//角色id
	private Integer characterId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色进阶结果(0:成功，1：元宝不足，
			writeByte(buf, this.result);
			//角色id
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
			//角色进阶结果(0:成功，1：元宝不足，
			this.result = readByte(buf);
			//角色id
			this.characterId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色进阶结果(0:成功，1：元宝不足，
	 * @return 
	 */
	public Byte getResult(){
		return result;
	}
	
	/**
	 * set 角色进阶结果(0:成功，1：元宝不足，
	 */
	public void setResult(Byte result){
		this.result = result;
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
	
	
	@Override
	public int getId() {
		return 200202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色进阶结果(0:成功，1：元宝不足，
		buf.append("result:" + result +",");
		//角色id
		buf.append("characterId:" + characterId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}