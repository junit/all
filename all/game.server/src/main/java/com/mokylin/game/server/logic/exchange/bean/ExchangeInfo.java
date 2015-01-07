package com.mokylin.game.server.logic.exchange.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 魂玉兑换信息
 */
public class ExchangeInfo extends Bean {

	private static Logger log = Logger.getLogger(ExchangeInfo.class);
	
	//环已兑换次数
	private Integer goldTimes;
	
	//环可兑换次数
	private Integer goldTotalTimes;
	
	//体力已兑换次数
	private Integer healthTimes;
	
	//体力可兑换次数
	private Integer healthTotalTimes;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//环已兑换次数
			writeInt(buf, this.goldTimes);
			//环可兑换次数
			writeInt(buf, this.goldTotalTimes);
			//体力已兑换次数
			writeInt(buf, this.healthTimes);
			//体力可兑换次数
			writeInt(buf, this.healthTotalTimes);
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
			//环已兑换次数
			this.goldTimes = readInt(buf);
			//环可兑换次数
			this.goldTotalTimes = readInt(buf);
			//体力已兑换次数
			this.healthTimes = readInt(buf);
			//体力可兑换次数
			this.healthTotalTimes = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 环已兑换次数
	 * @return 
	 */
	public Integer getGoldTimes(){
		return goldTimes;
	}
	
	/**
	 * set 环已兑换次数
	 */
	public void setGoldTimes(Integer goldTimes){
		this.goldTimes = goldTimes;
	}
	
	/**
	 * get 环可兑换次数
	 * @return 
	 */
	public Integer getGoldTotalTimes(){
		return goldTotalTimes;
	}
	
	/**
	 * set 环可兑换次数
	 */
	public void setGoldTotalTimes(Integer goldTotalTimes){
		this.goldTotalTimes = goldTotalTimes;
	}
	
	/**
	 * get 体力已兑换次数
	 * @return 
	 */
	public Integer getHealthTimes(){
		return healthTimes;
	}
	
	/**
	 * set 体力已兑换次数
	 */
	public void setHealthTimes(Integer healthTimes){
		this.healthTimes = healthTimes;
	}
	
	/**
	 * get 体力可兑换次数
	 * @return 
	 */
	public Integer getHealthTotalTimes(){
		return healthTotalTimes;
	}
	
	/**
	 * set 体力可兑换次数
	 */
	public void setHealthTotalTimes(Integer healthTotalTimes){
		this.healthTotalTimes = healthTotalTimes;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//环已兑换次数
		buf.append("goldTimes:" + goldTimes +",");
		//环可兑换次数
		buf.append("goldTotalTimes:" + goldTotalTimes +",");
		//体力已兑换次数
		buf.append("healthTimes:" + healthTimes +",");
		//体力可兑换次数
		buf.append("healthTotalTimes:" + healthTotalTimes +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}