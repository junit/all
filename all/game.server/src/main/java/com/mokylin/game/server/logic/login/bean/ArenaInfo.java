package com.mokylin.game.server.logic.login.bean;


import com.mokylin.game.core.message.Bean;

import io.netty.buffer.ByteBuf;

import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 玩家竞技场信息
 */
public class ArenaInfo extends Bean {

	private static Logger log = Logger.getLogger(ArenaInfo.class);
	
	//竞技场排名
	private Integer rank;
	
	//竞技场最高排名
	private Integer bestRank;
	
	//上次使用的角色id
	private Integer characterId;
	
	//战斗力
	private Integer fighting;
	
	//剩余挑战次数
	private Integer leftCount;
	
	//cd剩余秒数
	private Integer cdTime;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//竞技场排名
			writeInt(buf, this.rank);
			//竞技场最高排名
			writeInt(buf, this.bestRank);
			//上次使用的角色id
			writeInt(buf, this.characterId);
			//战斗力
			writeInt(buf, this.fighting);
			//剩余挑战次数
			writeInt(buf, this.leftCount);
			//cd剩余秒数
			writeInt(buf, this.cdTime);
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
			//竞技场排名
			this.rank = readInt(buf);
			//竞技场最高排名
			this.bestRank = readInt(buf);
			//上次使用的角色id
			this.characterId = readInt(buf);
			//战斗力
			this.fighting = readInt(buf);
			//剩余挑战次数
			this.leftCount = readInt(buf);
			//cd剩余秒数
			this.cdTime = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 竞技场排名
	 * @return 
	 */
	public Integer getRank(){
		return rank;
	}
	
	/**
	 * set 竞技场排名
	 */
	public void setRank(Integer rank){
		this.rank = rank;
	}
	
	/**
	 * get 竞技场最高排名
	 * @return 
	 */
	public Integer getBestRank(){
		return bestRank;
	}
	
	/**
	 * set 竞技场最高排名
	 */
	public void setBestRank(Integer bestRank){
		this.bestRank = bestRank;
	}
	
	/**
	 * get 上次使用的角色id
	 * @return 
	 */
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 上次使用的角色id
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
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
	
	/**
	 * get 剩余挑战次数
	 * @return 
	 */
	public Integer getLeftCount(){
		return leftCount;
	}
	
	/**
	 * set 剩余挑战次数
	 */
	public void setLeftCount(Integer leftCount){
		this.leftCount = leftCount;
	}
	
	/**
	 * get cd剩余秒数
	 * @return 
	 */
	public Integer getCdTime(){
		return cdTime;
	}
	
	/**
	 * set cd剩余秒数
	 */
	public void setCdTime(Integer cdTime){
		this.cdTime = cdTime;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//竞技场排名
		buf.append("rank:" + rank +",");
		//竞技场最高排名
		buf.append("bestRank:" + bestRank +",");
		//上次使用的角色id
		buf.append("characterId:" + characterId +",");
		//战斗力
		buf.append("fighting:" + fighting +",");
		//剩余挑战次数
		buf.append("leftCount:" + leftCount +",");
		//cd剩余秒数
		buf.append("cdTime:" + cdTime +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}