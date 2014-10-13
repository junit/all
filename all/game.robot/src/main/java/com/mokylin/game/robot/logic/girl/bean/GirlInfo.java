package com.mokylin.game.robot.logic.girl.bean;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 妹子信息
 */
public class GirlInfo extends Bean {

	private static Logger log = Logger.getLogger(GirlInfo.class);
	
	//妹子id
	private Integer girlId;
	
	//交往次数
	private Integer dateTimes;
	
	//今日交往次数
	private Integer todayTimes;
	
	//时装id
	private List<Integer> dressIds = new ArrayList<>();
	//当前时装id
	private Integer nowDress;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//妹子id
			writeInt(buf, this.girlId);
			//交往次数
			writeInt(buf, this.dateTimes);
			//今日交往次数
			writeInt(buf, this.todayTimes);
			//时装id
			writeShort(buf, (short)dressIds.size());
			for (int i = 0; i < dressIds.size(); i++) {
				writeInt(buf, dressIds.get(i));
			}
			//当前时装id
			writeInt(buf, this.nowDress);
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
			//妹子id
			this.girlId = readInt(buf);
			//交往次数
			this.dateTimes = readInt(buf);
			//今日交往次数
			this.todayTimes = readInt(buf);
			//时装id
			int dressIds_length = readShort(buf);
			for (int i = 0; i < dressIds_length; i++) {
				dressIds.add(readInt(buf));
			}
			//当前时装id
			this.nowDress = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 妹子id
	 * @return 
	 */
	public Integer getGirlId(){
		return girlId;
	}
	
	/**
	 * set 妹子id
	 */
	public void setGirlId(Integer girlId){
		this.girlId = girlId;
	}
	
	/**
	 * get 交往次数
	 * @return 
	 */
	public Integer getDateTimes(){
		return dateTimes;
	}
	
	/**
	 * set 交往次数
	 */
	public void setDateTimes(Integer dateTimes){
		this.dateTimes = dateTimes;
	}
	
	/**
	 * get 今日交往次数
	 * @return 
	 */
	public Integer getTodayTimes(){
		return todayTimes;
	}
	
	/**
	 * set 今日交往次数
	 */
	public void setTodayTimes(Integer todayTimes){
		this.todayTimes = todayTimes;
	}
	
	/**
	 * get 时装id
	 * @return 
	 */
	public List<Integer> getDressIds(){
		return dressIds;
	}
	
	/**
	 * set 时装id
	 */
	public void setDressIds(List<Integer> dressIds){
		this.dressIds = dressIds;
	}
	
	/**
	 * get 当前时装id
	 * @return 
	 */
	public Integer getNowDress(){
		return nowDress;
	}
	
	/**
	 * set 当前时装id
	 */
	public void setNowDress(Integer nowDress){
		this.nowDress = nowDress;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//妹子id
		buf.append("girlId:" + girlId +",");
		//交往次数
		buf.append("dateTimes:" + dateTimes +",");
		//今日交往次数
		buf.append("todayTimes:" + todayTimes +",");
		//时装id
		buf.append("dressIds:{");
		for (int i = 0; i < dressIds.size(); i++) {
			buf.append(dressIds.get(i) +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//当前时装id
		buf.append("nowDress:" + nowDress +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}