package com.mokylin.game.robot.logic.playersync.bean;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.playersync.bean.*;
import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 同步的玩家信息
 */
public class PlayerSyncInfo extends Bean {

	private static Logger log = Logger.getLogger(PlayerSyncInfo.class);
	
	//玩家id
	private Long playerId;
	
	//玩家名字
	private String playerName;
	
	//玩家等级
	private Integer playerLevel;
	
	//玩家vip等级
	private Integer vipLevel;
	
	//玩家战斗力
	private Integer fighting;
	
	//角色信息
	private List<CharacterSyncInfo> characterSyncInfo = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//玩家id
			writeLong(buf, this.playerId);
			//玩家名字
			writeString(buf, this.playerName);
			//玩家等级
			writeInt(buf, this.playerLevel);
			//玩家vip等级
			writeInt(buf, this.vipLevel);
			//玩家战斗力
			writeInt(buf, this.fighting);
			//角色信息
			writeShort(buf, (short)characterSyncInfo.size());
			for (int i = 0; i < characterSyncInfo.size(); i++) {
				writeBean(buf, characterSyncInfo.get(i));
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
			//玩家id
			this.playerId = readLong(buf);
			//玩家名字
			this.playerName = readString(buf);
			//玩家等级
			this.playerLevel = readInt(buf);
			//玩家vip等级
			this.vipLevel = readInt(buf);
			//玩家战斗力
			this.fighting = readInt(buf);
			//角色信息
			int characterSyncInfo_length = readShort(buf);
			for (int i = 0; i < characterSyncInfo_length; i++) {
				characterSyncInfo.add((CharacterSyncInfo)readBean(buf, CharacterSyncInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 玩家id
	 * @return 
	 */
	public Long getPlayerId(){
		return playerId;
	}
	
	/**
	 * set 玩家id
	 */
	public void setPlayerId(Long playerId){
		this.playerId = playerId;
	}
	
	/**
	 * get 玩家名字
	 * @return 
	 */
	public String getPlayerName(){
		return playerName;
	}
	
	/**
	 * set 玩家名字
	 */
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	
	/**
	 * get 玩家等级
	 * @return 
	 */
	public Integer getPlayerLevel(){
		return playerLevel;
	}
	
	/**
	 * set 玩家等级
	 */
	public void setPlayerLevel(Integer playerLevel){
		this.playerLevel = playerLevel;
	}
	
	/**
	 * get 玩家vip等级
	 * @return 
	 */
	public Integer getVipLevel(){
		return vipLevel;
	}
	
	/**
	 * set 玩家vip等级
	 */
	public void setVipLevel(Integer vipLevel){
		this.vipLevel = vipLevel;
	}
	
	/**
	 * get 玩家战斗力
	 * @return 
	 */
	public Integer getFighting(){
		return fighting;
	}
	
	/**
	 * set 玩家战斗力
	 */
	public void setFighting(Integer fighting){
		this.fighting = fighting;
	}
	
	/**
	 * get 角色信息
	 * @return 
	 */
	public List<CharacterSyncInfo> getCharacterSyncInfo(){
		return characterSyncInfo;
	}
	
	/**
	 * set 角色信息
	 */
	public void setCharacterSyncInfo(List<CharacterSyncInfo> characterSyncInfo){
		this.characterSyncInfo = characterSyncInfo;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//玩家id
		buf.append("playerId:" + playerId +",");
		//玩家名字
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		//玩家等级
		buf.append("playerLevel:" + playerLevel +",");
		//玩家vip等级
		buf.append("vipLevel:" + vipLevel +",");
		//玩家战斗力
		buf.append("fighting:" + fighting +",");
		//角色信息
		buf.append("characterSyncInfo:{");
		for (int i = 0; i < characterSyncInfo.size(); i++) {
			buf.append(characterSyncInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}