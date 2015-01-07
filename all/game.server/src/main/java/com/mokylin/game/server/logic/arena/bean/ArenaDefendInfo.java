package com.mokylin.game.server.logic.arena.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 竞技场被挑战纪录
 */
public class ArenaDefendInfo extends Bean {

	private static Logger log = Logger.getLogger(ArenaDefendInfo.class);
	
	//0：负，1：胜
	private Integer isWin;
	
	//对手名字
	private String playerName;
	
	//对手角色id
	private Integer characterId;
	
	//对手角色阶级
	private Integer characterStageLevel;
	
	//对手战斗力
	private Integer fighting;
	
	//原来的排名
	private Integer oldRank;
	
	//现在的排名
	private Integer newRank;
	
	//发生时间，0：一小时内，其他：几小时前
	private Integer fightTime;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0：负，1：胜
			writeInt(buf, this.isWin);
			//对手名字
			writeString(buf, this.playerName);
			//对手角色id
			writeInt(buf, this.characterId);
			//对手角色阶级
			writeInt(buf, this.characterStageLevel);
			//对手战斗力
			writeInt(buf, this.fighting);
			//原来的排名
			writeInt(buf, this.oldRank);
			//现在的排名
			writeInt(buf, this.newRank);
			//发生时间，0：一小时内，其他：几小时前
			writeInt(buf, this.fightTime);
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
			//0：负，1：胜
			this.isWin = readInt(buf);
			//对手名字
			this.playerName = readString(buf);
			//对手角色id
			this.characterId = readInt(buf);
			//对手角色阶级
			this.characterStageLevel = readInt(buf);
			//对手战斗力
			this.fighting = readInt(buf);
			//原来的排名
			this.oldRank = readInt(buf);
			//现在的排名
			this.newRank = readInt(buf);
			//发生时间，0：一小时内，其他：几小时前
			this.fightTime = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0：负，1：胜
	 * @return 
	 */
	public Integer getIsWin(){
		return isWin;
	}
	
	/**
	 * set 0：负，1：胜
	 */
	public void setIsWin(Integer isWin){
		this.isWin = isWin;
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
	
	/**
	 * get 原来的排名
	 * @return 
	 */
	public Integer getOldRank(){
		return oldRank;
	}
	
	/**
	 * set 原来的排名
	 */
	public void setOldRank(Integer oldRank){
		this.oldRank = oldRank;
	}
	
	/**
	 * get 现在的排名
	 * @return 
	 */
	public Integer getNewRank(){
		return newRank;
	}
	
	/**
	 * set 现在的排名
	 */
	public void setNewRank(Integer newRank){
		this.newRank = newRank;
	}
	
	/**
	 * get 发生时间，0：一小时内，其他：几小时前
	 * @return 
	 */
	public Integer getFightTime(){
		return fightTime;
	}
	
	/**
	 * set 发生时间，0：一小时内，其他：几小时前
	 */
	public void setFightTime(Integer fightTime){
		this.fightTime = fightTime;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0：负，1：胜
		buf.append("isWin:" + isWin +",");
		//对手名字
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		//对手角色id
		buf.append("characterId:" + characterId +",");
		//对手角色阶级
		buf.append("characterStageLevel:" + characterStageLevel +",");
		//对手战斗力
		buf.append("fighting:" + fighting +",");
		//原来的排名
		buf.append("oldRank:" + oldRank +",");
		//现在的排名
		buf.append("newRank:" + newRank +",");
		//发生时间，0：一小时内，其他：几小时前
		buf.append("fightTime:" + fightTime +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}