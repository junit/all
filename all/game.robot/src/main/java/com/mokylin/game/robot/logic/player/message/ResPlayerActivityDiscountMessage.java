package com.mokylin.game.robot.logic.player.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.player.bean.*;
import com.mokylin.game.core.message.Message;

import io.netty.buffer.ByteBuf;

import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 系统折扣消息
 */
public class ResPlayerActivityDiscountMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerActivityDiscountMessage.class);
	
	//折扣
	private List<DiscountInfo> discounts = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//折扣
			writeShort(buf, (short)discounts.size());
			for (int i = 0; i < discounts.size(); i++) {
				writeBean(buf, discounts.get(i));
			}
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
			//折扣
			int discounts_length = readShort(buf);
			for (int i = 0; i < discounts_length; i++) {
				discounts.add((DiscountInfo)readBean(buf, DiscountInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 折扣
	 * @return 
	 */
	public List<DiscountInfo> getDiscounts(){
		return discounts;
	}
	
	/**
	 * set 折扣
	 */
	public void setDiscounts(List<DiscountInfo> discounts){
		this.discounts = discounts;
	}
	
	
	@Override
	public int getId() {
		return 105107;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//折扣
		buf.append("discounts:{");
		for (int i = 0; i < discounts.size(); i++) {
			buf.append(discounts.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}