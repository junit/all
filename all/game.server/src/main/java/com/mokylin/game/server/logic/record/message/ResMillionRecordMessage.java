package com.mokylin.game.server.logic.record.message;


import com.mokylin.game.server.logic.record.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 百万招财世界纪录消息
 */
public class ResMillionRecordMessage extends Message{

	private static Logger log = Logger.getLogger(ResMillionRecordMessage.class);
	
	//百万招财世界纪录
	private MillionRecord millionRecord;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//百万招财世界纪录
			writeBean(buf, this.millionRecord);
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
			//百万招财世界纪录
			this.millionRecord = (MillionRecord)readBean(buf, MillionRecord.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 百万招财世界纪录
	 * @return 
	 */
	public MillionRecord getMillionRecord(){
		return millionRecord;
	}
	
	/**
	 * set 百万招财世界纪录
	 */
	public void setMillionRecord(MillionRecord millionRecord){
		this.millionRecord = millionRecord;
	}
	
	
	@Override
	public int getId() {
		return 202103;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//百万招财世界纪录
		if(this.millionRecord!=null) buf.append("millionRecord:" + millionRecord.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}