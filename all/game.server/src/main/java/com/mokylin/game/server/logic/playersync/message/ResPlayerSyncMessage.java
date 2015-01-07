package com.mokylin.game.server.logic.playersync.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.server.logic.playersync.bean.*;
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
public class ResPlayerSyncMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerSyncMessage.class);
	
	//
	private List<PlayerSyncInfo> playerSyncInfo = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//
			writeShort(buf, (short)playerSyncInfo.size());
			for (int i = 0; i < playerSyncInfo.size(); i++) {
				writeBean(buf, playerSyncInfo.get(i));
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
			//
			int playerSyncInfo_length = readShort(buf);
			for (int i = 0; i < playerSyncInfo_length; i++) {
				playerSyncInfo.add((PlayerSyncInfo)readBean(buf, PlayerSyncInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 
	 * @return 
	 */
	public List<PlayerSyncInfo> getPlayerSyncInfo(){
		return playerSyncInfo;
	}
	
	/**
	 * set 
	 */
	public void setPlayerSyncInfo(List<PlayerSyncInfo> playerSyncInfo){
		this.playerSyncInfo = playerSyncInfo;
	}
	
	
	@Override
	public int getId() {
		return 501101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//
		buf.append("playerSyncInfo:{");
		for (int i = 0; i < playerSyncInfo.size(); i++) {
			buf.append(playerSyncInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}