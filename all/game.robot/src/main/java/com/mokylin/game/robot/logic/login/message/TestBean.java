package com.mokylin.game.robot.logic.login.message;


import com.mokylin.game.core.message.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 道具信息
 */
public class TestBean extends Bean {

	private static Logger log = Logger.getLogger(TestBean.class);
	
	//道具model
	private Integer itemId;
	
	//道具数量
	private Integer itemCount;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//道具model
			writeInt(buf, this.itemId);
			//道具数量
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
			//道具model
			this.itemId = readInt(buf);
			//道具数量
			this.itemCount = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 道具model
	 * @return 
	 */
	public Integer getItemId(){
		return itemId;
	}
	
	/**
	 * set 道具model
	 */
	public void setItemId(Integer itemId){
		this.itemId = itemId;
	}
	
	/**
	 * get 道具数量
	 * @return 
	 */
	public Integer getItemCount(){
		return itemCount;
	}
	
	/**
	 * set 道具数量
	 */
	public void setItemCount(Integer itemCount){
		this.itemCount = itemCount;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//道具model
		buf.append("itemId:" + itemId +",");
		//道具数量
		buf.append("itemCount:" + itemCount +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}