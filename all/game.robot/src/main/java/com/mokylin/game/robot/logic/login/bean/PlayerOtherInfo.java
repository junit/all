package com.mokylin.game.robot.logic.login.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 玩家其他的数据，不好分类的
 */
public class PlayerOtherInfo extends Bean {

	private static Logger log = Logger.getLogger(PlayerOtherInfo.class);
	
	//进入温泉次数
	private Integer spaTimes;
	
	//浦元商店购买次数
	private Integer puyuanTimes;
	
	//烹饪普通食物次数
	private Integer foodTimes;
	
	//连续登录天数
	private Integer continuousLoginDay;
	
	//最大连续登录天数
	private Integer maxContinuousLoginDay;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//进入温泉次数
			writeInt(buf, this.spaTimes);
			//浦元商店购买次数
			writeInt(buf, this.puyuanTimes);
			//烹饪普通食物次数
			writeInt(buf, this.foodTimes);
			//连续登录天数
			writeInt(buf, this.continuousLoginDay);
			//最大连续登录天数
			writeInt(buf, this.maxContinuousLoginDay);
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
			//进入温泉次数
			this.spaTimes = readInt(buf);
			//浦元商店购买次数
			this.puyuanTimes = readInt(buf);
			//烹饪普通食物次数
			this.foodTimes = readInt(buf);
			//连续登录天数
			this.continuousLoginDay = readInt(buf);
			//最大连续登录天数
			this.maxContinuousLoginDay = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 进入温泉次数
	 * @return 
	 */
	public Integer getSpaTimes(){
		return spaTimes;
	}
	
	/**
	 * set 进入温泉次数
	 */
	public void setSpaTimes(Integer spaTimes){
		this.spaTimes = spaTimes;
	}
	
	/**
	 * get 浦元商店购买次数
	 * @return 
	 */
	public Integer getPuyuanTimes(){
		return puyuanTimes;
	}
	
	/**
	 * set 浦元商店购买次数
	 */
	public void setPuyuanTimes(Integer puyuanTimes){
		this.puyuanTimes = puyuanTimes;
	}
	
	/**
	 * get 烹饪普通食物次数
	 * @return 
	 */
	public Integer getFoodTimes(){
		return foodTimes;
	}
	
	/**
	 * set 烹饪普通食物次数
	 */
	public void setFoodTimes(Integer foodTimes){
		this.foodTimes = foodTimes;
	}
	
	/**
	 * get 连续登录天数
	 * @return 
	 */
	public Integer getContinuousLoginDay(){
		return continuousLoginDay;
	}
	
	/**
	 * set 连续登录天数
	 */
	public void setContinuousLoginDay(Integer continuousLoginDay){
		this.continuousLoginDay = continuousLoginDay;
	}
	
	/**
	 * get 最大连续登录天数
	 * @return 
	 */
	public Integer getMaxContinuousLoginDay(){
		return maxContinuousLoginDay;
	}
	
	/**
	 * set 最大连续登录天数
	 */
	public void setMaxContinuousLoginDay(Integer maxContinuousLoginDay){
		this.maxContinuousLoginDay = maxContinuousLoginDay;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//进入温泉次数
		buf.append("spaTimes:" + spaTimes +",");
		//浦元商店购买次数
		buf.append("puyuanTimes:" + puyuanTimes +",");
		//烹饪普通食物次数
		buf.append("foodTimes:" + foodTimes +",");
		//连续登录天数
		buf.append("continuousLoginDay:" + continuousLoginDay +",");
		//最大连续登录天数
		buf.append("maxContinuousLoginDay:" + maxContinuousLoginDay +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}