package com.mokylin.game.server.logic.login.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 连续登录天数消息
 */
public class ResLoginContinuousLoginDayMessage extends Message{

	private static Logger log = Logger.getLogger(ResLoginContinuousLoginDayMessage.class);
	
	//天数
	private Integer day;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//天数
			writeInt(buf, this.day);
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
			//天数
			this.day = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 天数
	 * @return 
	 */
	public Integer getDay(){
		return day;
	}
	
	/**
	 * set 天数
	 */
	public void setDay(Integer day){
		this.day = day;
	}
	
	
	@Override
	public int getId() {
		return 100105;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//天数
		buf.append("day:" + day +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}