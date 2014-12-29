package com.mokylin.game.robot.logic.arena.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 竞技场挑战者信息
 */
public class ArenaOpponentInfo extends Bean {

	private static Logger log = Logger.getLogger(ArenaOpponentInfo.class);
	
	//对手竞技场排名
	private Integer rank;
	
	//对手id
	private Long playerId;
	
	//对手等级
	private Integer playerLevel;
	
	//对手名字
	private String playerName;
	
	//对手角色id
	private Integer characterId;
	
	//角色阶级
	private Integer characterStageLevel;
	
	//对手战斗力
	private Integer fighting;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//对手竞技场排名
			writeInt(buf, this.rank);
			//对手id
			writeLong(buf, this.playerId);
			//对手等级
			writeInt(buf, this.playerLevel);
			//对手名字
			writeString(buf, this.playerName);
			//对手角色id
			writeInt(buf, this.characterId);
			//角色阶级
			writeInt(buf, this.characterStageLevel);
			//对手战斗力
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
			//对手竞技场排名
			this.rank = readInt(buf);
			//对手id
			this.playerId = readLong(buf);
			//对手等级
			this.playerLevel = readInt(buf);
			//对手名字
			this.playerName = readString(buf);
			//对手角色id
			this.characterId = readInt(buf);
			//角色阶级
			this.characterStageLevel = readInt(buf);
			//对手战斗力
			this.fighting = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 对手竞技场排名
	 * @return 
	 */
	public Integer getRank(){
		return rank;
	}
	
	/**
	 * set 对手竞技场排名
	 */
	public void setRank(Integer rank){
		this.rank = rank;
	}
	
	/**
	 * get 对手id
	 * @return 
	 */
	public Long getPlayerId(){
		return playerId;
	}
	
	/**
	 * set 对手id
	 */
	public void setPlayerId(Long playerId){
		this.playerId = playerId;
	}
	
	/**
	 * get 对手等级
	 * @return 
	 */
	public Integer getPlayerLevel(){
		return playerLevel;
	}
	
	/**
	 * set 对手等级
	 */
	public void setPlayerLevel(Integer playerLevel){
		this.playerLevel = playerLevel;
	}
	
	/**
	 * get 对手名字
	 * @return 
	 */
	public String getPlayerName(){
		return playerName;
	}
	
	/**
	 * set 对手名字
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
	 * get 角色阶级
	 * @return 
	 */
	public Integer getCharacterStageLevel(){
		return characterStageLevel;
	}
	
	/**
	 * set 角色阶级
	 */
	public void setCharacterStageLevel(Integer characterStageLevel){
		this.characterStageLevel = characterStageLevel;
	}
	
	/**
	 * get 对手战斗力
	 * @return 
	 */
	public Integer getFighting(){
		return fighting;
	}
	
	/**
	 * set 对手战斗力
	 */
	public void setFighting(Integer fighting){
		this.fighting = fighting;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//对手竞技场排名
		buf.append("rank:" + rank +",");
		//对手id
		buf.append("playerId:" + playerId +",");
		//对手等级
		buf.append("playerLevel:" + playerLevel +",");
		//对手名字
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		//对手角色id
		buf.append("characterId:" + characterId +",");
		//角色阶级
		buf.append("characterStageLevel:" + characterStageLevel +",");
		//对手战斗力
		buf.append("fighting:" + fighting +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}