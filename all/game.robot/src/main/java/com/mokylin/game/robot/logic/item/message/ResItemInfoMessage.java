package com.mokylin.game.robot.logic.item.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.item.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 同步玩家所有物品信息消息
 */
public class ResItemInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResItemInfoMessage.class);
	
	//物品信息列表
	private List<ItemInfo> itemInfos = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//物品信息列表
			writeShort(buf, (short)itemInfos.size());
			for (int i = 0; i < itemInfos.size(); i++) {
				writeBean(buf, itemInfos.get(i));
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
			//物品信息列表
			int itemInfos_length = readShort(buf);
			for (int i = 0; i < itemInfos_length; i++) {
				itemInfos.add((ItemInfo)readBean(buf, ItemInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 物品信息列表
	 * @return 
	 */
	public List<ItemInfo> getItemInfos(){
		return itemInfos;
	}
	
	/**
	 * set 物品信息列表
	 */
	public void setItemInfos(List<ItemInfo> itemInfos){
		this.itemInfos = itemInfos;
	}
	
	
	@Override
	public int getId() {
		return 101101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//物品信息列表
		buf.append("itemInfos:{");
		for (int i = 0; i < itemInfos.size(); i++) {
			buf.append(itemInfos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}