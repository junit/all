package com.mokylin.game.robot.logic.exchange.message;


import com.mokylin.game.robot.logic.exchange.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 兑换信息消息
 */
public class ResExchangeInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResExchangeInfoMessage.class);
	
	//魂玉兑换信息
	private ExchangeInfo exchangeInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//魂玉兑换信息
			writeBean(buf, this.exchangeInfo);
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
			//魂玉兑换信息
			this.exchangeInfo = (ExchangeInfo)readBean(buf, ExchangeInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 魂玉兑换信息
	 * @return 
	 */
	public ExchangeInfo getExchangeInfo(){
		return exchangeInfo;
	}
	
	/**
	 * set 魂玉兑换信息
	 */
	public void setExchangeInfo(ExchangeInfo exchangeInfo){
		this.exchangeInfo = exchangeInfo;
	}
	
	
	@Override
	public int getId() {
		return 207101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//魂玉兑换信息
		if(this.exchangeInfo!=null) buf.append("exchangeInfo:" + exchangeInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}