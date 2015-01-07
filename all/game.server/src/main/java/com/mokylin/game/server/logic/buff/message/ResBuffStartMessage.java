package com.mokylin.game.server.logic.buff.message;


import com.mokylin.game.server.logic.buff.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * Buff开始消息
 */
public class ResBuffStartMessage extends Message{

	private static Logger log = Logger.getLogger(ResBuffStartMessage.class);
	
	//Buff信息
	private BuffInfo info;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//Buff信息
			writeBean(buf, this.info);
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
			//Buff信息
			this.info = (BuffInfo)readBean(buf, BuffInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get Buff信息
	 * @return 
	 */
	public BuffInfo getInfo(){
		return info;
	}
	
	/**
	 * set Buff信息
	 */
	public void setInfo(BuffInfo info){
		this.info = info;
	}
	
	
	@Override
	public int getId() {
		return 203101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//Buff信息
		if(this.info!=null) buf.append("info:" + info.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}