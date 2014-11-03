package com.mokylin.game.robot.logic.player.message;


import com.mokylin.game.core.message.Message;

import io.netty.buffer.ByteBuf;

import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 玩家体力回复消息
 */
public class ResRecoverHealthMessage extends Message{

	private static Logger log = Logger.getLogger(ResRecoverHealthMessage.class);
	
	//当前体力
	private Integer health;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//当前体力
			writeInt(buf, this.health);
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
			//当前体力
			this.health = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 当前体力
	 * @return 
	 */
	public Integer getHealth(){
		return health;
	}
	
	/**
	 * set 当前体力
	 */
	public void setHealth(Integer health){
		this.health = health;
	}
	
	
	@Override
	public int getId() {
		return 105105;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//当前体力
		buf.append("health:" + health +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}