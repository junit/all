package com.mokylin.game.server.logic.level.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 关卡固定奖励信息
 */
public class FixedRewardInfo extends Bean {

	private static Logger log = Logger.getLogger(FixedRewardInfo.class);
	
	//金钱奖励
	private Integer money;
	
	//灵子奖励
	private Integer soul;
	
	//经验奖励
	private Integer exp;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//金钱奖励
			writeInt(buf, this.money);
			//灵子奖励
			writeInt(buf, this.soul);
			//经验奖励
			writeInt(buf, this.exp);
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
			//金钱奖励
			this.money = readInt(buf);
			//灵子奖励
			this.soul = readInt(buf);
			//经验奖励
			this.exp = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 金钱奖励
	 * @return 
	 */
	public Integer getMoney(){
		return money;
	}
	
	/**
	 * set 金钱奖励
	 */
	public void setMoney(Integer money){
		this.money = money;
	}
	
	/**
	 * get 灵子奖励
	 * @return 
	 */
	public Integer getSoul(){
		return soul;
	}
	
	/**
	 * set 灵子奖励
	 */
	public void setSoul(Integer soul){
		this.soul = soul;
	}
	
	/**
	 * get 经验奖励
	 * @return 
	 */
	public Integer getExp(){
		return exp;
	}
	
	/**
	 * set 经验奖励
	 */
	public void setExp(Integer exp){
		this.exp = exp;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//金钱奖励
		buf.append("money:" + money +",");
		//灵子奖励
		buf.append("soul:" + soul +",");
		//经验奖励
		buf.append("exp:" + exp +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}