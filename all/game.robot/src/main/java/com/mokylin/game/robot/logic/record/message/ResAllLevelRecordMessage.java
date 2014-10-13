package com.mokylin.game.robot.logic.record.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.record.bean.*;
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
public class ResAllLevelRecordMessage extends Message{

	private static Logger log = Logger.getLogger(ResAllLevelRecordMessage.class);
	
	//各关卡通关世界纪录
	private List<LevelRecord> levelRecord = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//各关卡通关世界纪录
			writeShort(buf, (short)levelRecord.size());
			for (int i = 0; i < levelRecord.size(); i++) {
				writeBean(buf, levelRecord.get(i));
			}
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
			int levelRecord_length = readShort(buf);
			for (int i = 0; i < levelRecord_length; i++) {
				levelRecord.add((LevelRecord)readBean(buf, LevelRecord.class));
			}
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
	public List<LevelRecord> getLevelRecord(){
		return levelRecord;
	}
	
	/**
	 * set 各关卡通关世界纪录
	 */
	public void setLevelRecord(List<LevelRecord> levelRecord){
		this.levelRecord = levelRecord;
	}
	
	
	@Override
	public int getId() {
		return 202101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//各关卡通关世界纪录
		buf.append("levelRecord:{");
		for (int i = 0; i < levelRecord.size(); i++) {
			buf.append(levelRecord.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}