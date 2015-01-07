package com.mokylin.game.server.logic.signin.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 玩家签到信息
 */
public class SigninInfo extends Bean {

	private static Logger log = Logger.getLogger(SigninInfo.class);
	
	//当前月份(从0开始)
	private Integer month;
	
	//当前月份第几天(从1开始)
	private Integer day;
	
	//今日是否已经签到（0：没有签到，非0：今日已经签到）
	private Byte todaySigned;
	
	//当月已签到次数
	private Integer monthSignedNum;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//当前月份(从0开始)
			writeInt(buf, this.month);
			//当前月份第几天(从1开始)
			writeInt(buf, this.day);
			//今日是否已经签到（0：没有签到，非0：今日已经签到）
			writeByte(buf, this.todaySigned);
			//当月已签到次数
			writeInt(buf, this.monthSignedNum);
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
			//当前月份(从0开始)
			this.month = readInt(buf);
			//当前月份第几天(从1开始)
			this.day = readInt(buf);
			//今日是否已经签到（0：没有签到，非0：今日已经签到）
			this.todaySigned = readByte(buf);
			//当月已签到次数
			this.monthSignedNum = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 当前月份(从0开始)
	 * @return 
	 */
	public Integer getMonth(){
		return month;
	}
	
	/**
	 * set 当前月份(从0开始)
	 */
	public void setMonth(Integer month){
		this.month = month;
	}
	
	/**
	 * get 当前月份第几天(从1开始)
	 * @return 
	 */
	public Integer getDay(){
		return day;
	}
	
	/**
	 * set 当前月份第几天(从1开始)
	 */
	public void setDay(Integer day){
		this.day = day;
	}
	
	/**
	 * get 今日是否已经签到（0：没有签到，非0：今日已经签到）
	 * @return 
	 */
	public Byte getTodaySigned(){
		return todaySigned;
	}
	
	/**
	 * set 今日是否已经签到（0：没有签到，非0：今日已经签到）
	 */
	public void setTodaySigned(Byte todaySigned){
		this.todaySigned = todaySigned;
	}
	
	/**
	 * get 当月已签到次数
	 * @return 
	 */
	public Integer getMonthSignedNum(){
		return monthSignedNum;
	}
	
	/**
	 * set 当月已签到次数
	 */
	public void setMonthSignedNum(Integer monthSignedNum){
		this.monthSignedNum = monthSignedNum;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//当前月份(从0开始)
		buf.append("month:" + month +",");
		//当前月份第几天(从1开始)
		buf.append("day:" + day +",");
		//今日是否已经签到（0：没有签到，非0：今日已经签到）
		buf.append("todaySigned:" + todaySigned +",");
		//当月已签到次数
		buf.append("monthSignedNum:" + monthSignedNum +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}