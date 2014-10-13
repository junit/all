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
 * 玩家竞技场信息消息
 */
public class ResPlayerArenaInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerArenaInfoMessage.class);
	
	//玩家竞技场信息
	private ArenaInfo arenaInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//玩家竞技场信息
			writeBean(buf, this.arenaInfo);
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
			//玩家竞技场信息
			this.arenaInfo = (ArenaInfo)readBean(buf, ArenaInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 玩家竞技场信息
	 * @return 
	 */
	public ArenaInfo getArenaInfo(){
		return arenaInfo;
	}
	
	/**
	 * set 玩家竞技场信息
	 */
	public void setArenaInfo(ArenaInfo arenaInfo){
		this.arenaInfo = arenaInfo;
	}
	
	
	@Override
	public int getId() {
		return 206105;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//玩家竞技场信息
		if(this.arenaInfo!=null) buf.append("arenaInfo:" + arenaInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}