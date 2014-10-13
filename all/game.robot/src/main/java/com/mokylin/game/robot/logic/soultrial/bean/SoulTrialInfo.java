package com.mokylin.game.robot.logic.soultrial.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 灵魂试炼信息
 */
public class SoulTrialInfo extends Bean {

	private static Logger log = Logger.getLogger(SoulTrialInfo.class);
	
	//灵魂试炼已通过的最大id
	private Integer maxId;
	
	//灵魂试炼可重新开始次数
	private Integer count;
	
	//是否已领取单关奖励,0:未领取， 1：已领取
	private Integer oneReward;
	
	//是否已领取已通关总奖励,0:未领取， 1：已领取
	private Integer allReward;
	
	//最后出战角色id
	private Integer characterId;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//灵魂试炼已通过的最大id
			writeInt(buf, this.maxId);
			//灵魂试炼可重新开始次数
			writeInt(buf, this.count);
			//是否已领取单关奖励,0:未领取， 1：已领取
			writeInt(buf, this.oneReward);
			//是否已领取已通关总奖励,0:未领取， 1：已领取
			writeInt(buf, this.allReward);
			//最后出战角色id
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
			//灵魂试炼已通过的最大id
			this.maxId = readInt(buf);
			//灵魂试炼可重新开始次数
			this.count = readInt(buf);
			//是否已领取单关奖励,0:未领取， 1：已领取
			this.oneReward = readInt(buf);
			//是否已领取已通关总奖励,0:未领取， 1：已领取
			this.allReward = readInt(buf);
			//最后出战角色id
			this.characterId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 灵魂试炼已通过的最大id
	 * @return 
	 */
	public Integer getMaxId(){
		return maxId;
	}
	
	/**
	 * set 灵魂试炼已通过的最大id
	 */
	public void setMaxId(Integer maxId){
		this.maxId = maxId;
	}
	
	/**
	 * get 灵魂试炼可重新开始次数
	 * @return 
	 */
	public Integer getCount(){
		return count;
	}
	
	/**
	 * set 灵魂试炼可重新开始次数
	 */
	public void setCount(Integer count){
		this.count = count;
	}
	
	/**
	 * get 是否已领取单关奖励,0:未领取， 1：已领取
	 * @return 
	 */
	public Integer getOneReward(){
		return oneReward;
	}
	
	/**
	 * set 是否已领取单关奖励,0:未领取， 1：已领取
	 */
	public void setOneReward(Integer oneReward){
		this.oneReward = oneReward;
	}
	
	/**
	 * get 是否已领取已通关总奖励,0:未领取， 1：已领取
	 * @return 
	 */
	public Integer getAllReward(){
		return allReward;
	}
	
	/**
	 * set 是否已领取已通关总奖励,0:未领取， 1：已领取
	 */
	public void setAllReward(Integer allReward){
		this.allReward = allReward;
	}
	
	/**
	 * get 最后出战角色id
	 * @return 
	 */
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 最后出战角色id
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//灵魂试炼已通过的最大id
		buf.append("maxId:" + maxId +",");
		//灵魂试炼可重新开始次数
		buf.append("count:" + count +",");
		//是否已领取单关奖励,0:未领取， 1：已领取
		buf.append("oneReward:" + oneReward +",");
		//是否已领取已通关总奖励,0:未领取， 1：已领取
		buf.append("allReward:" + allReward +",");
		//最后出战角色id
		buf.append("characterId:" + characterId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}