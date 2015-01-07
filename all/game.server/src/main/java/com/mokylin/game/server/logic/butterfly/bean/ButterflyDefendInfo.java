package com.mokylin.game.server.logic.butterfly.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 地狱蝶防守纪录
 */
public class ButterflyDefendInfo extends Bean {

	private static Logger log = Logger.getLogger(ButterflyDefendInfo.class);
	
	//被抢地狱蝶个数，0：被抢失败，其他>0：被抢个数
	private Integer robCount;
	
	//对手名字
	private String playerName;
	
	//对手角色id
	private Integer characterId;
	
	//对手角色阶级
	private Integer characterStageLevel;
	
	//对手战斗力
	private Integer fighting;
	
	//发生时间，0：一小时内，其他：几小时前
	private Integer fightTime;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//被抢地狱蝶个数，0：被抢失败，其他>0：被抢个数
			writeInt(buf, this.robCount);
			//对手名字
			writeString(buf, this.playerName);
			//对手角色id
			writeInt(buf, this.characterId);
			//对手角色阶级
			writeInt(buf, this.characterStageLevel);
			//对手战斗力
			writeInt(buf, this.fighting);
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
			//被抢地狱蝶个数，0：被抢失败，其他>0：被抢个数
			this.robCount = readInt(buf);
			//对手名字
			this.playerName = readString(buf);
			//对手角色id
			this.characterId = readInt(buf);
			//对手角色阶级
			this.characterStageLevel = readInt(buf);
			//对手战斗力
			this.fighting = readInt(buf);
			//发生时间，0：一小时内，其他：几小时前
			this.fightTime = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 被抢地狱蝶个数，0：被抢失败，其他>0：被抢个数
	 * @return 
	 */
	public Integer getRobCount(){
		return robCount;
	}
	
	/**
	 * set 被抢地狱蝶个数，0：被抢失败，其他>0：被抢个数
	 */
	public void setRobCount(Integer robCount){
		this.robCount = robCount;
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
		//被抢地狱蝶个数，0：被抢失败，其他>0：被抢个数
		buf.append("robCount:" + robCount +",");
		//对手名字
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		//对手角色id
		buf.append("characterId:" + characterId +",");
		//对手角色阶级
		buf.append("characterStageLevel:" + characterStageLevel +",");
		//对手战斗力
		buf.append("fighting:" + fighting +",");
		//发生时间，0：一小时内，其他：几小时前
		buf.append("fightTime:" + fightTime +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}