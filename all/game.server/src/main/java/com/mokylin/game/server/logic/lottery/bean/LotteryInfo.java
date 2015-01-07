package com.mokylin.game.server.logic.lottery.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 抽奖系统信息
 */
public class LotteryInfo extends Bean {

	private static Logger log = Logger.getLogger(LotteryInfo.class);
	
	//a类型免费领取剩余次数
	private Integer aLeftCount;
	
	//a类型领取时间间隔剩余秒数
	private Integer aCdTime;
	
	//0：非首抽，1：首抽
	private Integer aFirstTime;
	
	//a类型抽奖次数
	private Integer aLotteryCount;
	
	//b类型领取时间间隔剩余秒数
	private Integer bCdTime;
	
	//0：非首抽，1：首抽
	private Integer bFirstTime;
	
	//b类型抽奖次数
	private Integer bLotteryCount;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//a类型免费领取剩余次数
			writeInt(buf, this.aLeftCount);
			//a类型领取时间间隔剩余秒数
			writeInt(buf, this.aCdTime);
			//0：非首抽，1：首抽
			writeInt(buf, this.aFirstTime);
			//a类型抽奖次数
			writeInt(buf, this.aLotteryCount);
			//b类型领取时间间隔剩余秒数
			writeInt(buf, this.bCdTime);
			//0：非首抽，1：首抽
			writeInt(buf, this.bFirstTime);
			//b类型抽奖次数
			writeInt(buf, this.bLotteryCount);
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
			//a类型免费领取剩余次数
			this.aLeftCount = readInt(buf);
			//a类型领取时间间隔剩余秒数
			this.aCdTime = readInt(buf);
			//0：非首抽，1：首抽
			this.aFirstTime = readInt(buf);
			//a类型抽奖次数
			this.aLotteryCount = readInt(buf);
			//b类型领取时间间隔剩余秒数
			this.bCdTime = readInt(buf);
			//0：非首抽，1：首抽
			this.bFirstTime = readInt(buf);
			//b类型抽奖次数
			this.bLotteryCount = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get a类型免费领取剩余次数
	 * @return 
	 */
	public Integer getALeftCount(){
		return aLeftCount;
	}
	
	/**
	 * set a类型免费领取剩余次数
	 */
	public void setALeftCount(Integer aLeftCount){
		this.aLeftCount = aLeftCount;
	}
	
	/**
	 * get a类型领取时间间隔剩余秒数
	 * @return 
	 */
	public Integer getACdTime(){
		return aCdTime;
	}
	
	/**
	 * set a类型领取时间间隔剩余秒数
	 */
	public void setACdTime(Integer aCdTime){
		this.aCdTime = aCdTime;
	}
	
	/**
	 * get 0：非首抽，1：首抽
	 * @return 
	 */
	public Integer getAFirstTime(){
		return aFirstTime;
	}
	
	/**
	 * set 0：非首抽，1：首抽
	 */
	public void setAFirstTime(Integer aFirstTime){
		this.aFirstTime = aFirstTime;
	}
	
	/**
	 * get a类型抽奖次数
	 * @return 
	 */
	public Integer getALotteryCount(){
		return aLotteryCount;
	}
	
	/**
	 * set a类型抽奖次数
	 */
	public void setALotteryCount(Integer aLotteryCount){
		this.aLotteryCount = aLotteryCount;
	}
	
	/**
	 * get b类型领取时间间隔剩余秒数
	 * @return 
	 */
	public Integer getBCdTime(){
		return bCdTime;
	}
	
	/**
	 * set b类型领取时间间隔剩余秒数
	 */
	public void setBCdTime(Integer bCdTime){
		this.bCdTime = bCdTime;
	}
	
	/**
	 * get 0：非首抽，1：首抽
	 * @return 
	 */
	public Integer getBFirstTime(){
		return bFirstTime;
	}
	
	/**
	 * set 0：非首抽，1：首抽
	 */
	public void setBFirstTime(Integer bFirstTime){
		this.bFirstTime = bFirstTime;
	}
	
	/**
	 * get b类型抽奖次数
	 * @return 
	 */
	public Integer getBLotteryCount(){
		return bLotteryCount;
	}
	
	/**
	 * set b类型抽奖次数
	 */
	public void setBLotteryCount(Integer bLotteryCount){
		this.bLotteryCount = bLotteryCount;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//a类型免费领取剩余次数
		buf.append("aLeftCount:" + aLeftCount +",");
		//a类型领取时间间隔剩余秒数
		buf.append("aCdTime:" + aCdTime +",");
		//0：非首抽，1：首抽
		buf.append("aFirstTime:" + aFirstTime +",");
		//a类型抽奖次数
		buf.append("aLotteryCount:" + aLotteryCount +",");
		//b类型领取时间间隔剩余秒数
		buf.append("bCdTime:" + bCdTime +",");
		//0：非首抽，1：首抽
		buf.append("bFirstTime:" + bFirstTime +",");
		//b类型抽奖次数
		buf.append("bLotteryCount:" + bLotteryCount +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}