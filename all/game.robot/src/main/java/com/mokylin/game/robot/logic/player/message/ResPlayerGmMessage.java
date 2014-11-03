package com.mokylin.game.robot.logic.player.message;


import com.mokylin.game.core.message.Message;

import io.netty.buffer.ByteBuf;

import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * GM指令返回消息
 */
public class ResPlayerGmMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerGmMessage.class);
	
	//返回
	private String ret;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//返回
			writeString(buf, this.ret);
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
			//返回
			this.ret = readString(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 返回
	 * @return 
	 */
	public String getRet(){
		return ret;
	}
	
	/**
	 * set 返回
	 */
	public void setRet(String ret){
		this.ret = ret;
	}
	
	
	@Override
	public int getId() {
		return 105106;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//返回
		if(this.ret!=null) buf.append("ret:" + ret.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}