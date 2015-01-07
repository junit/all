package com.mokylin.game.server.logic.item.message;


import com.mokylin.game.server.logic.item.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 同步玩家单个物品信息消息
 */
public class ResSingleItemInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResSingleItemInfoMessage.class);
	
	//物品信息
	private ItemInfo itemInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//物品信息
			writeBean(buf, this.itemInfo);
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
			//物品信息
			this.itemInfo = (ItemInfo)readBean(buf, ItemInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 物品信息
	 * @return 
	 */
	public ItemInfo getItemInfo(){
		return itemInfo;
	}
	
	/**
	 * set 物品信息
	 */
	public void setItemInfo(ItemInfo itemInfo){
		this.itemInfo = itemInfo;
	}
	
	
	@Override
	public int getId() {
		return 101102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//物品信息
		if(this.itemInfo!=null) buf.append("itemInfo:" + itemInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}