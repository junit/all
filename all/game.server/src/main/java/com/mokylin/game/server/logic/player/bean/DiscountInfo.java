package com.mokylin.game.server.logic.player.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 折扣
 */
public class DiscountInfo extends Bean {

	private static Logger log = Logger.getLogger(DiscountInfo.class);
	
	//3,浦原商店折扣 4,温泉消耗折扣 7,竞技商店折扣
	private Integer type;
	
	//折扣万分比
	private Integer discount;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//3,浦原商店折扣 4,温泉消耗折扣 7,竞技商店折扣
			writeInt(buf, this.type);
			//折扣万分比
			writeInt(buf, this.discount);
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
			//3,浦原商店折扣 4,温泉消耗折扣 7,竞技商店折扣
			this.type = readInt(buf);
			//折扣万分比
			this.discount = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 3,浦原商店折扣 4,温泉消耗折扣 7,竞技商店折扣
	 * @return 
	 */
	public Integer getType(){
		return type;
	}
	
	/**
	 * set 3,浦原商店折扣 4,温泉消耗折扣 7,竞技商店折扣
	 */
	public void setType(Integer type){
		this.type = type;
	}
	
	/**
	 * get 折扣万分比
	 * @return 
	 */
	public Integer getDiscount(){
		return discount;
	}
	
	/**
	 * set 折扣万分比
	 */
	public void setDiscount(Integer discount){
		this.discount = discount;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//3,浦原商店折扣 4,温泉消耗折扣 7,竞技商店折扣
		buf.append("type:" + type +",");
		//折扣万分比
		buf.append("discount:" + discount +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}