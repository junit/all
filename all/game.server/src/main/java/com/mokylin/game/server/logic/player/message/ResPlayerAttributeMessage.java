package com.mokylin.game.server.logic.player.message;


import com.mokylin.game.server.logic.player.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 同步玩家单个角色属性消息
 */
public class ResPlayerAttributeMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerAttributeMessage.class);
	
	//角色属性
	private AttributeInfo attributeInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色属性
			writeBean(buf, this.attributeInfo);
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
			//角色属性
			this.attributeInfo = (AttributeInfo)readBean(buf, AttributeInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色属性
	 * @return 
	 */
	public AttributeInfo getAttributeInfo(){
		return attributeInfo;
	}
	
	/**
	 * set 角色属性
	 */
	public void setAttributeInfo(AttributeInfo attributeInfo){
		this.attributeInfo = attributeInfo;
	}
	
	
	@Override
	public int getId() {
		return 105103;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色属性
		if(this.attributeInfo!=null) buf.append("attributeInfo:" + attributeInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}