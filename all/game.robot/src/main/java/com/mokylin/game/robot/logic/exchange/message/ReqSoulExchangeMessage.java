package com.mokylin.game.robot.logic.exchange.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 魂玉兑换请求消息
 */
public class ReqSoulExchangeMessage extends Message{

	private static Logger log = Logger.getLogger(ReqSoulExchangeMessage.class);
	
	//0：兑换环，1：兑换体力
	private Integer type;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0：兑换环，1：兑换体力
			writeInt(buf, this.type);
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
			//0：兑换环，1：兑换体力
			this.type = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0：兑换环，1：兑换体力
	 * @return 
	 */
	public Integer getType(){
		return type;
	}
	
	/**
	 * set 0：兑换环，1：兑换体力
	 */
	public void setType(Integer type){
		this.type = type;
	}
	
	
	@Override
	public int getId() {
		return 207201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0：兑换环，1：兑换体力
		buf.append("type:" + type +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}