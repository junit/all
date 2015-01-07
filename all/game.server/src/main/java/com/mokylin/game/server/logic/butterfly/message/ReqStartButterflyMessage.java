package com.mokylin.game.server.logic.butterfly.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 开始地狱蝶请求消息
 */
public class ReqStartButterflyMessage extends Message{

	private static Logger log = Logger.getLogger(ReqStartButterflyMessage.class);
	
	//角色id
	private Integer charId;
	//对手玩家id
	private Long playerId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.charId);
			//对手玩家id
			writeLong(buf, this.playerId);
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
			//对手玩家id
			this.playerId = readLong(buf);
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
	
	/**
	 * get 对手玩家id
	 * @return 
	 */
	public Long getPlayerId(){
		return playerId;
	}
	
	/**
	 * set 对手玩家id
	 */
	public void setPlayerId(Long playerId){
		this.playerId = playerId;
	}
	
	
	@Override
	public int getId() {
		return 211102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("charId:" + charId +",");
		//对手玩家id
		buf.append("playerId:" + playerId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}