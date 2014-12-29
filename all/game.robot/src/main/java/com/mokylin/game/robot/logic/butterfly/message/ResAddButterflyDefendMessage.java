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
 * 增加单条地狱蝶抢夺纪录消息
 */
public class ResAddButterflyDefendMessage extends Message{

	private static Logger log = Logger.getLogger(ResAddButterflyDefendMessage.class);
	
	//地狱蝶抢夺纪录
	private List<ButterflyDefendInfo> butterflyDefendInfo = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//地狱蝶抢夺纪录
			writeShort(buf, (short)butterflyDefendInfo.size());
			for (int i = 0; i < butterflyDefendInfo.size(); i++) {
				writeBean(buf, butterflyDefendInfo.get(i));
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
			//地狱蝶抢夺纪录
			int butterflyDefendInfo_length = readShort(buf);
			for (int i = 0; i < butterflyDefendInfo_length; i++) {
				butterflyDefendInfo.add((ButterflyDefendInfo)readBean(buf, ButterflyDefendInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 地狱蝶抢夺纪录
	 * @return 
	 */
	public List<ButterflyDefendInfo> getButterflyDefendInfo(){
		return butterflyDefendInfo;
	}
	
	/**
	 * set 地狱蝶抢夺纪录
	 */
	public void setButterflyDefendInfo(List<ButterflyDefendInfo> butterflyDefendInfo){
		this.butterflyDefendInfo = butterflyDefendInfo;
	}
	
	
	@Override
	public int getId() {
		return 211207;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//地狱蝶抢夺纪录
		buf.append("butterflyDefendInfo:{");
		for (int i = 0; i < butterflyDefendInfo.size(); i++) {
			buf.append(butterflyDefendInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}