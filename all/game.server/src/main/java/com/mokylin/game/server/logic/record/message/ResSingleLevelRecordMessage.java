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
 * 消息
 */
public class ResSingleLevelRecordMessage extends Message{

	private static Logger log = Logger.getLogger(ResSingleLevelRecordMessage.class);
	
	//各关卡通关世界纪录
	private LevelRecord levelRecord;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//各关卡通关世界纪录
			writeBean(buf, this.levelRecord);
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
			//各关卡通关世界纪录
			this.levelRecord = (LevelRecord)readBean(buf, LevelRecord.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 各关卡通关世界纪录
	 * @return 
	 */
	public LevelRecord getLevelRecord(){
		return levelRecord;
	}
	
	/**
	 * set 各关卡通关世界纪录
	 */
	public void setLevelRecord(LevelRecord levelRecord){
		this.levelRecord = levelRecord;
	}
	
	
	@Override
	public int getId() {
		return 202102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//各关卡通关世界纪录
		if(this.levelRecord!=null) buf.append("levelRecord:" + levelRecord.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}