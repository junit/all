package com.mokylin.game.robot.logic.level.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 物品奖励信息
 */
public class ItemRewardInfo extends Bean {

	private static Logger log = Logger.getLogger(ItemRewardInfo.class);
	
	//物品id
	private Integer itemId;
	
	//物品数量
	private Integer itemCount;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//物品id
			writeInt(buf, this.itemId);
			//物品数量
			writeInt(buf, this.itemCount);
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
			//物品id
			this.itemId = readInt(buf);
			//物品数量
			this.itemCount = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 物品id
	 * @return 
	 */
	public Integer getItemId(){
		return itemId;
	}
	
	/**
	 * set 物品id
	 */
	public void setItemId(Integer itemId){
		this.itemId = itemId;
	}
	
	/**
	 * get 物品数量
	 * @return 
	 */
	public Integer getItemCount(){
		return itemCount;
	}
	
	/**
	 * set 物品数量
	 */
	public void setItemCount(Integer itemCount){
		this.itemCount = itemCount;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//物品id
		buf.append("itemId:" + itemId +",");
		//物品数量
		buf.append("itemCount:" + itemCount +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}