package com.mokylin.game.server.logic.shop.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 商店道具信息
 */
public class ShopItemInfo extends Bean {

	private static Logger log = Logger.getLogger(ShopItemInfo.class);
	
	//序号
	private Integer index;
	
	//商品id
	private Integer shopItemId;
	
	//剩余数量
	private Integer num;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//序号
			writeInt(buf, this.index);
			//商品id
			writeInt(buf, this.shopItemId);
			//剩余数量
			writeInt(buf, this.num);
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
			//序号
			this.index = readInt(buf);
			//商品id
			this.shopItemId = readInt(buf);
			//剩余数量
			this.num = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 序号
	 * @return 
	 */
	public Integer getIndex(){
		return index;
	}
	
	/**
	 * set 序号
	 */
	public void setIndex(Integer index){
		this.index = index;
	}
	
	/**
	 * get 商品id
	 * @return 
	 */
	public Integer getShopItemId(){
		return shopItemId;
	}
	
	/**
	 * set 商品id
	 */
	public void setShopItemId(Integer shopItemId){
		this.shopItemId = shopItemId;
	}
	
	/**
	 * get 剩余数量
	 * @return 
	 */
	public Integer getNum(){
		return num;
	}
	
	/**
	 * set 剩余数量
	 */
	public void setNum(Integer num){
		this.num = num;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//序号
		buf.append("index:" + index +",");
		//商品id
		buf.append("shopItemId:" + shopItemId +",");
		//剩余数量
		buf.append("num:" + num +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}