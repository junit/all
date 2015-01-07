package com.mokylin.game.server.logic.butterfly.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 刷新地狱蝶数量消息
 */
public class ResRefreshButterflyCountMessage extends Message{

	private static Logger log = Logger.getLogger(ResRefreshButterflyCountMessage.class);
	
	//地狱蝶最新数量
	private Integer count;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//地狱蝶最新数量
			writeInt(buf, this.count);
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
			//地狱蝶最新数量
			this.count = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 地狱蝶最新数量
	 * @return 
	 */
	public Integer getCount(){
		return count;
	}
	
	/**
	 * set 地狱蝶最新数量
	 */
	public void setCount(Integer count){
		this.count = count;
	}
	
	
	@Override
	public int getId() {
		return 211208;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//地狱蝶最新数量
		buf.append("count:" + count +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}