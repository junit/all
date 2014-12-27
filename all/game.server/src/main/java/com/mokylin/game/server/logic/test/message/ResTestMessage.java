package com.mokylin.game.server.logic.test.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * test消息
 */
public class ResTestMessage extends Message{

	private static Logger log = Logger.getLogger(ResTestMessage.class);
	
	//time
	private long time;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//time
			writeLong(buf, this.time);
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
	public long getTime(){
		return time;
	}
	
	/**
	 * set time
	 */
	public void setTime(long time){
		this.time = time;
	}
	
	
	@Override
	public int getId() {
		return 100200;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//time
		buf.append("time:" + time +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}