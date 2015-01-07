package com.mokylin.game.server.logic.ranking.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 竞技场排行榜
 */
public class ArenaRankingBean extends Bean {

	private static Logger log = Logger.getLogger(ArenaRankingBean.class);
	
	//排名
	private Integer rank;
	
	//玩家名字
	private String playerName;
	
	//玩家等级
	private Integer playerLevel;
	
	//角色id
	private Integer characterId;
	
	//角色阶级
	private Integer characterStageLevel;
	
	//战斗力
	private Integer fighting;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//排名
			writeInt(buf, this.rank);
			//玩家名字
			writeString(buf, this.playerName);
			//玩家等级
			writeInt(buf, this.playerLevel);
			//角色id
			writeInt(buf, this.characterId);
			//角色阶级
			writeInt(buf, this.characterStageLevel);
			//战斗力
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
			//排名
			this.rank = readInt(buf);
			//玩家名字
			this.playerName = readString(buf);
			//玩家等级
			this.playerLevel = readInt(buf);
			//角色id
			this.characterId = readInt(buf);
			//角色阶级
			this.characterStageLevel = readInt(buf);
			//战斗力
			this.fighting = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 排名
	 * @return 
	 */
	public Integer getRank(){
		return rank;
	}
	
	/**
	 * set 排名
	 */
	public void setRank(Integer rank){
		this.rank = rank;
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
	 * get 玩家等级
	 * @return 
	 */
	public Integer getPlayerLevel(){
		return playerLevel;
	}
	
	/**
	 * set 玩家等级
	 */
	public void setPlayerLevel(Integer playerLevel){
		this.playerLevel = playerLevel;
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
	 * get 战斗力
	 * @return 
	 */
	public Integer getFighting(){
		return fighting;
	}
	
	/**
	 * set 战斗力
	 */
	public void setFighting(Integer fighting){
		this.fighting = fighting;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//排名
		buf.append("rank:" + rank +",");
		//玩家名字
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		//玩家等级
		buf.append("playerLevel:" + playerLevel +",");
		//角色id
		buf.append("characterId:" + characterId +",");
		//角色阶级
		buf.append("characterStageLevel:" + characterStageLevel +",");
		//战斗力
		buf.append("fighting:" + fighting +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}