package com.mokylin.game.server.logic.account.message;


import com.mokylin.game.core.message.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 测试消息
 */
public class ResAccountTestMessage extends Message{

	private static Logger log = Logger.getLogger(ResAccountTestMessage.class);
	
	//time
	private Long time;
	//字符串
	private String str;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//time
			writeLong(buf, this.time);
			//字符串
			writeString(buf, this.str);
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
			//time
			this.time = readLong(buf);
			//字符串
			this.str = readString(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get time
	 * @return 
	 */
	public Long getTime(){
		return time;
	}
	
	/**
	 * set time
	 */
	public void setTime(Long time){
		this.time = time;
	}
	
	/**
	 * get 字符串
	 * @return 
	 */
	public String getStr(){
		return str;
	}
	
	/**
	 * set 字符串
	 */
	public void setStr(String str){
		this.str = str;
	}
	
	
	@Override
	public int getId() {
		return 100202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//time
		buf.append("time:" + time +",");
		//字符串
		if(this.str!=null) buf.append("str:" + str.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}