package com.mokylin.game.server.logic.food.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 烹饪普通食物次数消息
 */
public class ResFoodTimesMessage extends Message{

	private static Logger log = Logger.getLogger(ResFoodTimesMessage.class);
	
	//次数
	private Integer times;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//次数
			writeInt(buf, this.times);
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
			//次数
			this.times = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 次数
	 * @return 
	 */
	public Integer getTimes(){
		return times;
	}
	
	/**
	 * set 次数
	 */
	public void setTimes(Integer times){
		this.times = times;
	}
	
	
	@Override
	public int getId() {
		return 106103;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//次数
		buf.append("times:" + times +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}