package com.mokylin.game.server.logic.player.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.server.logic.player.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 同步玩家所有角色属性消息
 */
public class ResPlayerAttributesMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerAttributesMessage.class);
	
	//角色属性
	private List<AttributeInfo> attributeInfos = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色属性
			writeShort(buf, (short)attributeInfos.size());
			for (int i = 0; i < attributeInfos.size(); i++) {
				writeBean(buf, attributeInfos.get(i));
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
			//角色属性
			int attributeInfos_length = readShort(buf);
			for (int i = 0; i < attributeInfos_length; i++) {
				attributeInfos.add((AttributeInfo)readBean(buf, AttributeInfo.class));
			}
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
	public List<AttributeInfo> getAttributeInfos(){
		return attributeInfos;
	}
	
	/**
	 * set 角色属性
	 */
	public void setAttributeInfos(List<AttributeInfo> attributeInfos){
		this.attributeInfos = attributeInfos;
	}
	
	
	@Override
	public int getId() {
		return 105102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色属性
		buf.append("attributeInfos:{");
		for (int i = 0; i < attributeInfos.size(); i++) {
			buf.append(attributeInfos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}