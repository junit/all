package com.mokylin.game.server.logic.discovery.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回前端请求开始探索结果消息
 */
public class ResBeginDiscoveryMessage extends Message{

	private static Logger log = Logger.getLogger(ResBeginDiscoveryMessage.class);
	
	//开始探索结果消息id（0：成功，非0：失败的消息id）
	private Integer msg;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//开始探索结果消息id（0：成功，非0：失败的消息id）
			writeInt(buf, this.msg);
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
			//开始探索结果消息id（0：成功，非0：失败的消息id）
			this.msg = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 开始探索结果消息id（0：成功，非0：失败的消息id）
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 开始探索结果消息id（0：成功，非0：失败的消息id）
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
	}
	
	
	@Override
	public int getId() {
		return 303101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//开始探索结果消息id（0：成功，非0：失败的消息id）
		buf.append("msg:" + msg +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}