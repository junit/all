package com.mokylin.game.robot.logic.arena.message;


import com.mokylin.game.robot.logic.arena.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 增加单场竞技场被挑战纪录消息
 */
public class ResAddArenaDefendInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResAddArenaDefendInfoMessage.class);
	
	//竞技场被挑战纪录列表
	private ArenaDefendInfo arenaDefendInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//竞技场被挑战纪录列表
			writeBean(buf, this.arenaDefendInfo);
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
			this.arenaDefendInfo = (ArenaDefendInfo)readBean(buf, ArenaDefendInfo.class);
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
	public ArenaDefendInfo getArenaDefendInfo(){
		return arenaDefendInfo;
	}
	
	/**
	 * set 竞技场被挑战纪录列表
	 */
	public void setArenaDefendInfo(ArenaDefendInfo arenaDefendInfo){
		this.arenaDefendInfo = arenaDefendInfo;
	}
	
	
	@Override
	public int getId() {
		return 206111;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//竞技场被挑战纪录列表
		if(this.arenaDefendInfo!=null) buf.append("arenaDefendInfo:" + arenaDefendInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}