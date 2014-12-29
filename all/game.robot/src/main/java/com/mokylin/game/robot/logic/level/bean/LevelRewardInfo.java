package com.mokylin.game.robot.logic.level.bean;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.bean.Bean;
import com.mokylin.game.robot.logic.item.bean.ItemInfo;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 关卡奖励信息
 */
public class LevelRewardInfo extends Bean {

	private static Logger log = Logger.getLogger(LevelRewardInfo.class);
	
	//固定奖励
	private FixedRewardInfo fixedRewardInfo;
	
	//随机奖励
	private List<ItemInfo> randomRewardInfo = new ArrayList<>();
	//首次通关奖励
	private List<ItemInfo> firstFightReward = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//固定奖励
			writeBean(buf, this.fixedRewardInfo);
			//随机奖励
			writeShort(buf, (short)randomRewardInfo.size());
			for (int i = 0; i < randomRewardInfo.size(); i++) {
				writeBean(buf, randomRewardInfo.get(i));
			}
			//首次通关奖励
			writeShort(buf, (short)firstFightReward.size());
			for (int i = 0; i < firstFightReward.size(); i++) {
				writeBean(buf, firstFightReward.get(i));
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
			//固定奖励
			this.fixedRewardInfo = (FixedRewardInfo)readBean(buf, FixedRewardInfo.class);
			//随机奖励
			int randomRewardInfo_length = readShort(buf);
			for (int i = 0; i < randomRewardInfo_length; i++) {
				randomRewardInfo.add((ItemInfo)readBean(buf, ItemInfo.class));
			}
			//首次通关奖励
			int firstFightReward_length = readShort(buf);
			for (int i = 0; i < firstFightReward_length; i++) {
				firstFightReward.add((ItemInfo)readBean(buf, ItemInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 固定奖励
	 * @return 
	 */
	public FixedRewardInfo getFixedRewardInfo(){
		return fixedRewardInfo;
	}
	
	/**
	 * set 固定奖励
	 */
	public void setFixedRewardInfo(FixedRewardInfo fixedRewardInfo){
		this.fixedRewardInfo = fixedRewardInfo;
	}
	
	/**
	 * get 随机奖励
	 * @return 
	 */
	public List<ItemInfo> getRandomRewardInfo(){
		return randomRewardInfo;
	}
	
	/**
	 * set 随机奖励
	 */
	public void setRandomRewardInfo(List<ItemInfo> randomRewardInfo){
		this.randomRewardInfo = randomRewardInfo;
	}
	
	/**
	 * get 首次通关奖励
	 * @return 
	 */
	public List<ItemInfo> getFirstFightReward(){
		return firstFightReward;
	}
	
	/**
	 * set 首次通关奖励
	 */
	public void setFirstFightReward(List<ItemInfo> firstFightReward){
		this.firstFightReward = firstFightReward;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//固定奖励
		if(this.fixedRewardInfo!=null) buf.append("fixedRewardInfo:" + fixedRewardInfo.toString() +",");
		//随机奖励
		buf.append("randomRewardInfo:{");
		for (int i = 0; i < randomRewardInfo.size(); i++) {
			buf.append(randomRewardInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//首次通关奖励
		buf.append("firstFightReward:{");
		for (int i = 0; i < firstFightReward.size(); i++) {
			buf.append(firstFightReward.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}