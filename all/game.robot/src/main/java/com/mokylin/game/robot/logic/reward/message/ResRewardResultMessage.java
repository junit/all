package com.mokylin.game.robot.logic.reward.message;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.bean.Message;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 消息
 */
public class ResRewardResultMessage extends Message{

	private static Logger log = Logger.getLogger(ResRewardResultMessage.class);
	
	//奖励系统类型
	private Integer systemType;
	//奖励信息
	private List<com.mokylin.game.robot.logic.item.bean.ItemInfo> rewardInfo = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//奖励系统类型
			writeInt(buf, this.systemType);
			//奖励信息
			writeShort(buf, (short)rewardInfo.size());
			for (int i = 0; i < rewardInfo.size(); i++) {
				writeBean(buf, rewardInfo.get(i));
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
			//奖励系统类型
			this.systemType = readInt(buf);
			//奖励信息
			int rewardInfo_length = readShort(buf);
			for (int i = 0; i < rewardInfo_length; i++) {
				rewardInfo.add((com.mokylin.game.robot.logic.item.bean.ItemInfo)readBean(buf, com.mokylin.game.robot.logic.item.bean.ItemInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 奖励系统类型
	 * @return 
	 */
	public Integer getSystemType(){
		return systemType;
	}
	
	/**
	 * set 奖励系统类型
	 */
	public void setSystemType(Integer systemType){
		this.systemType = systemType;
	}
	
	/**
	 * get 奖励信息
	 * @return 
	 */
	public List<com.mokylin.game.robot.logic.item.bean.ItemInfo> getRewardInfo(){
		return rewardInfo;
	}
	
	/**
	 * set 奖励信息
	 */
	public void setRewardInfo(List<com.mokylin.game.robot.logic.item.bean.ItemInfo> rewardInfo){
		this.rewardInfo = rewardInfo;
	}
	
	
	@Override
	public int getId() {
		return 205101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//奖励系统类型
		buf.append("systemType:" + systemType +",");
		//奖励信息
		buf.append("rewardInfo:{");
		for (int i = 0; i < rewardInfo.size(); i++) {
			buf.append(rewardInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}