package com.mokylin.game.robot.logic.character.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 解锁角色请求消息
 */
public class ReqUnLockCharacterMessage extends Message{

	private static Logger log = Logger.getLogger(ReqUnLockCharacterMessage.class);
	
	//角色id
	private Integer charId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.charId);
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
			this.charId = readInt(buf);
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
	public Integer getCharId(){
		return charId;
	}
	
	/**
	 * set 角色id
	 */
	public void setCharId(Integer charId){
		this.charId = charId;
	}
	
	
	@Override
	public int getId() {
		return 200101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("charId:" + charId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}