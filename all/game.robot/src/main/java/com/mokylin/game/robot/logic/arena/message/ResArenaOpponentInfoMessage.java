package com.mokylin.game.robot.logic.arena.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.arena.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 竞技场对手列表消息
 */
public class ResArenaOpponentInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResArenaOpponentInfoMessage.class);
	
	//竞技场挑战者列表
	private List<ArenaOpponentInfo> arenaOpponetInfo = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//竞技场挑战者列表
			writeShort(buf, (short)arenaOpponetInfo.size());
			for (int i = 0; i < arenaOpponetInfo.size(); i++) {
				writeBean(buf, arenaOpponetInfo.get(i));
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
			//竞技场挑战者列表
			int arenaOpponetInfo_length = readShort(buf);
			for (int i = 0; i < arenaOpponetInfo_length; i++) {
				arenaOpponetInfo.add((ArenaOpponentInfo)readBean(buf, ArenaOpponentInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 竞技场挑战者列表
	 * @return 
	 */
	public List<ArenaOpponentInfo> getArenaOpponetInfo(){
		return arenaOpponetInfo;
	}
	
	/**
	 * set 竞技场挑战者列表
	 */
	public void setArenaOpponetInfo(List<ArenaOpponentInfo> arenaOpponetInfo){
		this.arenaOpponetInfo = arenaOpponetInfo;
	}
	
	
	@Override
	public int getId() {
		return 206102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//竞技场挑战者列表
		buf.append("arenaOpponetInfo:{");
		for (int i = 0; i < arenaOpponetInfo.size(); i++) {
			buf.append(arenaOpponetInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}