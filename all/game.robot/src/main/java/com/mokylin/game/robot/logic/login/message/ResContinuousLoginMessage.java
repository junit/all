package com.mokylin.game.robot.logic.login.message;


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
public class ResContinuousLoginMessage extends Message{

	private static Logger log = Logger.getLogger(ResContinuousLoginMessage.class);
	
	//连续天数
	private Integer day;
	//最大连续天数
	private Integer maxDay;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//连续天数
			writeInt(buf, this.day);
			//最大连续天数
			writeInt(buf, this.maxDay);
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
			//连续天数
			this.day = readInt(buf);
			//最大连续天数
			this.maxDay = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 连续天数
	 * @return 
	 */
	public Integer getDay(){
		return day;
	}
	
	/**
	 * set 连续天数
	 */
	public void setDay(Integer day){
		this.day = day;
	}
	
	/**
	 * get 最大连续天数
	 * @return 
	 */
	public Integer getMaxDay(){
		return maxDay;
	}
	
	/**
	 * set 最大连续天数
	 */
	public void setMaxDay(Integer maxDay){
		this.maxDay = maxDay;
	}
	
	
	@Override
	public int getId() {
		return 100104;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//连续天数
		buf.append("day:" + day +",");
		//最大连续天数
		buf.append("maxDay:" + maxDay +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}