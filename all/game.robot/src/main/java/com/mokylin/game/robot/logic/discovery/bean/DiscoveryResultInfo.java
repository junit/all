package com.mokylin.game.robot.logic.discovery.bean;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 探索结果信息
 */
public class DiscoveryResultInfo extends Bean {

	private static Logger log = Logger.getLogger(DiscoveryResultInfo.class);
	
	//当前探索id
	private Integer discoveryId;
	
	//正在探索的角色
	private List<Integer> discoveryCharacters = new ArrayList<>();
	//已探索时长（0为未探索，大于0小于探索配置时长为探索中，大于等于探索配置时长探索完成），单位为毫秒
	private Long discoveryTime;
	
	//已打开宝箱数量
	private Integer openedChestNum;
	
	//今日探索已经使用过的角色
	private List<Integer> discoveryTodayUsedCharacters = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//当前探索id
			writeInt(buf, this.discoveryId);
			//正在探索的角色
			writeShort(buf, (short)discoveryCharacters.size());
			for (int i = 0; i < discoveryCharacters.size(); i++) {
				writeInt(buf, discoveryCharacters.get(i));
			}
			//已探索时长（0为未探索，大于0小于探索配置时长为探索中，大于等于探索配置时长探索完成），单位为毫秒
			writeLong(buf, this.discoveryTime);
			//已打开宝箱数量
			writeInt(buf, this.openedChestNum);
			//今日探索已经使用过的角色
			writeShort(buf, (short)discoveryTodayUsedCharacters.size());
			for (int i = 0; i < discoveryTodayUsedCharacters.size(); i++) {
				writeInt(buf, discoveryTodayUsedCharacters.get(i));
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
			//当前探索id
			this.discoveryId = readInt(buf);
			//正在探索的角色
			int discoveryCharacters_length = readShort(buf);
			for (int i = 0; i < discoveryCharacters_length; i++) {
				discoveryCharacters.add(readInt(buf));
			}
			//已探索时长（0为未探索，大于0小于探索配置时长为探索中，大于等于探索配置时长探索完成），单位为毫秒
			this.discoveryTime = readLong(buf);
			//已打开宝箱数量
			this.openedChestNum = readInt(buf);
			//今日探索已经使用过的角色
			int discoveryTodayUsedCharacters_length = readShort(buf);
			for (int i = 0; i < discoveryTodayUsedCharacters_length; i++) {
				discoveryTodayUsedCharacters.add(readInt(buf));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 当前探索id
	 * @return 
	 */
	public Integer getDiscoveryId(){
		return discoveryId;
	}
	
	/**
	 * set 当前探索id
	 */
	public void setDiscoveryId(Integer discoveryId){
		this.discoveryId = discoveryId;
	}
	
	/**
	 * get 正在探索的角色
	 * @return 
	 */
	public List<Integer> getDiscoveryCharacters(){
		return discoveryCharacters;
	}
	
	/**
	 * set 正在探索的角色
	 */
	public void setDiscoveryCharacters(List<Integer> discoveryCharacters){
		this.discoveryCharacters = discoveryCharacters;
	}
	
	/**
	 * get 已探索时长（0为未探索，大于0小于探索配置时长为探索中，大于等于探索配置时长探索完成），单位为毫秒
	 * @return 
	 */
	public Long getDiscoveryTime(){
		return discoveryTime;
	}
	
	/**
	 * set 已探索时长（0为未探索，大于0小于探索配置时长为探索中，大于等于探索配置时长探索完成），单位为毫秒
	 */
	public void setDiscoveryTime(Long discoveryTime){
		this.discoveryTime = discoveryTime;
	}
	
	/**
	 * get 已打开宝箱数量
	 * @return 
	 */
	public Integer getOpenedChestNum(){
		return openedChestNum;
	}
	
	/**
	 * set 已打开宝箱数量
	 */
	public void setOpenedChestNum(Integer openedChestNum){
		this.openedChestNum = openedChestNum;
	}
	
	/**
	 * get 今日探索已经使用过的角色
	 * @return 
	 */
	public List<Integer> getDiscoveryTodayUsedCharacters(){
		return discoveryTodayUsedCharacters;
	}
	
	/**
	 * set 今日探索已经使用过的角色
	 */
	public void setDiscoveryTodayUsedCharacters(List<Integer> discoveryTodayUsedCharacters){
		this.discoveryTodayUsedCharacters = discoveryTodayUsedCharacters;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//当前探索id
		buf.append("discoveryId:" + discoveryId +",");
		//正在探索的角色
		buf.append("discoveryCharacters:{");
		for (int i = 0; i < discoveryCharacters.size(); i++) {
			buf.append(discoveryCharacters.get(i) +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//已探索时长（0为未探索，大于0小于探索配置时长为探索中，大于等于探索配置时长探索完成），单位为毫秒
		buf.append("discoveryTime:" + discoveryTime +",");
		//已打开宝箱数量
		buf.append("openedChestNum:" + openedChestNum +",");
		//今日探索已经使用过的角色
		buf.append("discoveryTodayUsedCharacters:{");
		for (int i = 0; i < discoveryTodayUsedCharacters.size(); i++) {
			buf.append(discoveryTodayUsedCharacters.get(i) +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}