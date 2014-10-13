package com.mokylin.game.robot.logic.butterfly.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.butterfly.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 地狱蝶对手列表消息
 */
public class ResButterflyOpponentInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResButterflyOpponentInfoMessage.class);
	
	//地狱蝶对手列表
	private List<ButterflyOpponentInfo> butterflyOpponentInfo = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//地狱蝶对手列表
			writeShort(buf, (short)butterflyOpponentInfo.size());
			for (int i = 0; i < butterflyOpponentInfo.size(); i++) {
				writeBean(buf, butterflyOpponentInfo.get(i));
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
			//地狱蝶对手列表
			int butterflyOpponentInfo_length = readShort(buf);
			for (int i = 0; i < butterflyOpponentInfo_length; i++) {
				butterflyOpponentInfo.add((ButterflyOpponentInfo)readBean(buf, ButterflyOpponentInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 地狱蝶对手列表
	 * @return 
	 */
	public List<ButterflyOpponentInfo> getButterflyOpponentInfo(){
		return butterflyOpponentInfo;
	}
	
	/**
	 * set 地狱蝶对手列表
	 */
	public void setButterflyOpponentInfo(List<ButterflyOpponentInfo> butterflyOpponentInfo){
		this.butterflyOpponentInfo = butterflyOpponentInfo;
	}
	
	
	@Override
	public int getId() {
		return 211205;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//地狱蝶对手列表
		buf.append("butterflyOpponentInfo:{");
		for (int i = 0; i < butterflyOpponentInfo.size(); i++) {
			buf.append(butterflyOpponentInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}