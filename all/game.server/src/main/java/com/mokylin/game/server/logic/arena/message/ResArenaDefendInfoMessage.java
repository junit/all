package com.mokylin.game.server.logic.arena.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.server.logic.arena.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 竞技场被挑战纪录消息
 */
public class ResArenaDefendInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResArenaDefendInfoMessage.class);
	
	//竞技场被挑战纪录列表
	private List<ArenaDefendInfo> arenaDefendInfo = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//竞技场被挑战纪录列表
			writeShort(buf, (short)arenaDefendInfo.size());
			for (int i = 0; i < arenaDefendInfo.size(); i++) {
				writeBean(buf, arenaDefendInfo.get(i));
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
			//竞技场被挑战纪录列表
			int arenaDefendInfo_length = readShort(buf);
			for (int i = 0; i < arenaDefendInfo_length; i++) {
				arenaDefendInfo.add((ArenaDefendInfo)readBean(buf, ArenaDefendInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 竞技场被挑战纪录列表
	 * @return 
	 */
	public List<ArenaDefendInfo> getArenaDefendInfo(){
		return arenaDefendInfo;
	}
	
	/**
	 * set 竞技场被挑战纪录列表
	 */
	public void setArenaDefendInfo(List<ArenaDefendInfo> arenaDefendInfo){
		this.arenaDefendInfo = arenaDefendInfo;
	}
	
	
	@Override
	public int getId() {
		return 206110;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//竞技场被挑战纪录列表
		buf.append("arenaDefendInfo:{");
		for (int i = 0; i < arenaDefendInfo.size(); i++) {
			buf.append(arenaDefendInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}