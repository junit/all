package com.mokylin.game.robot.logic.discovery.message;

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
 * 返回前端请求领取探索奖励消息
 */
public class ResReceiveDiscoveryRewardMessage extends Message{

	private static Logger log = Logger.getLogger(ResReceiveDiscoveryRewardMessage.class);
	
	//开始探索结果消息id（0：成功，非0：失败的消息id）
	private Integer msg;
	//物品奖励信息（灵子奖励和物品奖励）
	private List<com.mokylin.game.robot.logic.item.bean.ItemInfo> baseRewardInfos = new ArrayList<>();
	//物品奖励信息（灵子奖励，金钱奖励（环），物品奖励）
	private List<com.mokylin.game.robot.logic.item.bean.ItemInfo> treasureRewardInfos = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//开始探索结果消息id（0：成功，非0：失败的消息id）
			writeInt(buf, this.msg);
			//物品奖励信息（灵子奖励和物品奖励）
			writeShort(buf, (short)baseRewardInfos.size());
			for (int i = 0; i < baseRewardInfos.size(); i++) {
				writeBean(buf, baseRewardInfos.get(i));
			}
			//物品奖励信息（灵子奖励，金钱奖励（环），物品奖励）
			writeShort(buf, (short)treasureRewardInfos.size());
			for (int i = 0; i < treasureRewardInfos.size(); i++) {
				writeBean(buf, treasureRewardInfos.get(i));
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
			//开始探索结果消息id（0：成功，非0：失败的消息id）
			this.msg = readInt(buf);
			//物品奖励信息（灵子奖励和物品奖励）
			int baseRewardInfos_length = readShort(buf);
			for (int i = 0; i < baseRewardInfos_length; i++) {
				baseRewardInfos.add((com.mokylin.game.robot.logic.item.bean.ItemInfo)readBean(buf, com.mokylin.game.robot.logic.item.bean.ItemInfo.class));
			}
			//物品奖励信息（灵子奖励，金钱奖励（环），物品奖励）
			int treasureRewardInfos_length = readShort(buf);
			for (int i = 0; i < treasureRewardInfos_length; i++) {
				treasureRewardInfos.add((com.mokylin.game.robot.logic.item.bean.ItemInfo)readBean(buf, com.mokylin.game.robot.logic.item.bean.ItemInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 开始探索结果消息id（0：成功，非0：失败的消息id）
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 开始探索结果消息id（0：成功，非0：失败的消息id）
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
	}
	
	/**
	 * get 物品奖励信息（灵子奖励和物品奖励）
	 * @return 
	 */
	public List<com.mokylin.game.robot.logic.item.bean.ItemInfo> getBaseRewardInfos(){
		return baseRewardInfos;
	}
	
	/**
	 * set 物品奖励信息（灵子奖励和物品奖励）
	 */
	public void setBaseRewardInfos(List<com.mokylin.game.robot.logic.item.bean.ItemInfo> baseRewardInfos){
		this.baseRewardInfos = baseRewardInfos;
	}
	
	/**
	 * get 物品奖励信息（灵子奖励，金钱奖励（环），物品奖励）
	 * @return 
	 */
	public List<com.mokylin.game.robot.logic.item.bean.ItemInfo> getTreasureRewardInfos(){
		return treasureRewardInfos;
	}
	
	/**
	 * set 物品奖励信息（灵子奖励，金钱奖励（环），物品奖励）
	 */
	public void setTreasureRewardInfos(List<com.mokylin.game.robot.logic.item.bean.ItemInfo> treasureRewardInfos){
		this.treasureRewardInfos = treasureRewardInfos;
	}
	
	
	@Override
	public int getId() {
		return 303102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//开始探索结果消息id（0：成功，非0：失败的消息id）
		buf.append("msg:" + msg +",");
		//物品奖励信息（灵子奖励和物品奖励）
		buf.append("baseRewardInfos:{");
		for (int i = 0; i < baseRewardInfos.size(); i++) {
			buf.append(baseRewardInfos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//物品奖励信息（灵子奖励，金钱奖励（环），物品奖励）
		buf.append("treasureRewardInfos:{");
		for (int i = 0; i < treasureRewardInfos.size(); i++) {
			buf.append(treasureRewardInfos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}