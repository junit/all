package com.mokylin.game.server.logic.food.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 消食消息
 */
public class ReqFoodDigestMessage extends Message{

	private static Logger log = Logger.getLogger(ReqFoodDigestMessage.class);
	
	//0:使用魂玉 道具id:使用道具
	private Integer itemId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0:使用魂玉 道具id:使用道具
			writeInt(buf, this.itemId);
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
			//0:使用魂玉 道具id:使用道具
			this.itemId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0:使用魂玉 道具id:使用道具
	 * @return 
	 */
	public Integer getItemId(){
		return itemId;
	}
	
	/**
	 * set 0:使用魂玉 道具id:使用道具
	 */
	public void setItemId(Integer itemId){
		this.itemId = itemId;
	}
	
	
	@Override
	public int getId() {
		return 106202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0:使用魂玉 道具id:使用道具
		buf.append("itemId:" + itemId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}