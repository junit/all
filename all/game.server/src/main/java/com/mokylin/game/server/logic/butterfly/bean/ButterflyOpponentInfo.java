package com.mokylin.game.server.logic.butterfly.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 地狱蝶对手信息
 */
public class ButterflyOpponentInfo extends Bean {

	private static Logger log = Logger.getLogger(ButterflyOpponentInfo.class);
	
	//玩家id
	private Long playerId;
	
	//玩家名字
	private String playerName;
	
	//对手角色id
	private Integer characterId;
	
	//对手角色阶级
	private Integer characterStageLevel;
	
	//玩家地狱蝶数量
	private Integer butterflyCount;
	
	//玩家战斗力
	private Integer fighting;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//玩家id
			writeLong(buf, this.playerId);
			//玩家名字
			writeString(buf, this.playerName);
			//对手角色id
			writeInt(buf, this.characterId);
			//对手角色阶级
			writeInt(buf, this.characterStageLevel);
			//玩家地狱蝶数量
			writeInt(buf, this.butterflyCount);
			//玩家战斗力
			writeInt(buf, this.fighting);
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
			//玩家id
			this.playerId = readLong(buf);
			//玩家名字
			this.playerName = readString(buf);
			//对手角色id
			this.characterId = readInt(buf);
			//对手角色阶级
			this.characterStageLevel = readInt(buf);
			//玩家地狱蝶数量
			this.butterflyCount = readInt(buf);
			//玩家战斗力
			this.fighting = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 玩家id
	 * @return 
	 */
	public Long getPlayerId(){
		return playerId;
	}
	
	/**
	 * set 玩家id
	 */
	public void setPlayerId(Long playerId){
		this.playerId = playerId;
	}
	
	/**
	 * get 玩家名字
	 * @return 
	 */
	public String getPlayerName(){
		return playerName;
	}
	
	/**
	 * set 玩家名字
	 */
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	
	/**
	 * get 对手角色id
	 * @return 
	 */
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 对手角色id
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
	}
	
	/**
	 * get 对手角色阶级
	 * @return 
	 */
	public Integer getCharacterStageLevel(){
		return characterStageLevel;
	}
	
	/**
	 * set 对手角色阶级
	 */
	public void setCharacterStageLevel(Integer characterStageLevel){
		this.characterStageLevel = characterStageLevel;
	}
	
	/**
	 * get 玩家地狱蝶数量
	 * @return 
	 */
	public Integer getButterflyCount(){
		return butterflyCount;
	}
	
	/**
	 * set 玩家地狱蝶数量
	 */
	public void setButterflyCount(Integer butterflyCount){
		this.butterflyCount = butterflyCount;
	}
	
	/**
	 * get 玩家战斗力
	 * @return 
	 */
	public Integer getFighting(){
		return fighting;
	}
	
	/**
	 * set 玩家战斗力
	 */
	public void setFighting(Integer fighting){
		this.fighting = fighting;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//玩家id
		buf.append("playerId:" + playerId +",");
		//玩家名字
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		//对手角色id
		buf.append("characterId:" + characterId +",");
		//对手角色阶级
		buf.append("characterStageLevel:" + characterStageLevel +",");
		//玩家地狱蝶数量
		buf.append("butterflyCount:" + butterflyCount +",");
		//玩家战斗力
		buf.append("fighting:" + fighting +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}