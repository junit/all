package com.mokylin.game.robot.logic.arena.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 竞技场挑战开始请求消息
 */
public class ReqStartArenaMessage extends Message{

	private static Logger log = Logger.getLogger(ReqStartArenaMessage.class);
	
	//对手玩家id
	private Long oppPlayerId;
	//对手玩家排名
	private Integer oppPlayerRank;
	//使用的角色的id
	private Integer characterId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//对手玩家id
			writeLong(buf, this.oppPlayerId);
			//对手玩家排名
			writeInt(buf, this.oppPlayerRank);
			//使用的角色的id
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
			//对手玩家id
			this.oppPlayerId = readLong(buf);
			//对手玩家排名
			this.oppPlayerRank = readInt(buf);
			//使用的角色的id
			this.characterId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 对手玩家id
	 * @return 
	 */
	public Long getOppPlayerId(){
		return oppPlayerId;
	}
	
	/**
	 * set 对手玩家id
	 */
	public void setOppPlayerId(Long oppPlayerId){
		this.oppPlayerId = oppPlayerId;
	}
	
	/**
	 * get 对手玩家排名
	 * @return 
	 */
	public Integer getOppPlayerRank(){
		return oppPlayerRank;
	}
	
	/**
	 * set 对手玩家排名
	 */
	public void setOppPlayerRank(Integer oppPlayerRank){
		this.oppPlayerRank = oppPlayerRank;
	}
	
	/**
	 * get 使用的角色的id
	 * @return 
	 */
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 使用的角色的id
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
	}
	
	
	@Override
	public int getId() {
		return 206203;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//对手玩家id
		buf.append("oppPlayerId:" + oppPlayerId +",");
		//对手玩家排名
		buf.append("oppPlayerRank:" + oppPlayerRank +",");
		//使用的角色的id
		buf.append("characterId:" + characterId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}