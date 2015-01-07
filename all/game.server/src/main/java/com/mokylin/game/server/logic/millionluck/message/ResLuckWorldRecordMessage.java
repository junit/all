package com.mokylin.game.server.logic.millionluck.message;


import com.mokylin.game.server.logic.millionluck.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回前端招财世界纪录消息
 */
public class ResLuckWorldRecordMessage extends Message{

	private static Logger log = Logger.getLogger(ResLuckWorldRecordMessage.class);
	
	//招财世界记录
	private WorldLuckRecordInfo luckWorldRecord;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//招财世界记录
			writeBean(buf, this.luckWorldRecord);
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
			//招财世界记录
			this.luckWorldRecord = (WorldLuckRecordInfo)readBean(buf, WorldLuckRecordInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 招财世界记录
	 * @return 
	 */
	public WorldLuckRecordInfo getLuckWorldRecord(){
		return luckWorldRecord;
	}
	
	/**
	 * set 招财世界记录
	 */
	public void setLuckWorldRecord(WorldLuckRecordInfo luckWorldRecord){
		this.luckWorldRecord = luckWorldRecord;
	}
	
	
	@Override
	public int getId() {
		return 302103;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//招财世界记录
		if(this.luckWorldRecord!=null) buf.append("luckWorldRecord:" + luckWorldRecord.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}