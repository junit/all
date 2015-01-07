package com.mokylin.game.server.logic.character.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 重置角色阶段消息
 */
public class ResCharacterStageResetMessage extends Message{

	private static Logger log = Logger.getLogger(ResCharacterStageResetMessage.class);
	
	//0:成功，1：失败
	private Byte result;
	//角色id
	private Integer characterId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0:成功，1：失败
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
			//0:成功，1：失败
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
	 * get 0:成功，1：失败
	 * @return 
	 */
	public Byte getResult(){
		return result;
	}
	
	/**
	 * set 0:成功，1：失败
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
		return 200203;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0:成功，1：失败
		buf.append("result:" + result +",");
		//角色id
		buf.append("characterId:" + characterId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}