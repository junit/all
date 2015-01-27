package com.mokylin.game.robot.logic.player.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 角色基础数据
 */
public class PlayerBaseInfo extends Bean {

	private static Logger log = Logger.getLogger(PlayerBaseInfo.class);
	
	//账号id
	private Long accountId;
	
	//玩家id
	private Long playerId;
	
	//服务器id
	private Integer serverId;
	
	//玩家名字
	private String playerName;
	
	//玩家等级
	private Integer playerLevel;
	
	//vip等级
	private Integer vipLevel;
	
	//经验
	private Integer exp;
	
	//体力
	private Integer health;
	
	//金钱
	private Integer gold;
	
	//灵子
	private Integer spirit;
	
	//魂玉
	private Integer soul;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//账号id
			writeLong(buf, this.accountId);
			//玩家id
			writeLong(buf, this.playerId);
			//服务器id
			writeInt(buf, this.serverId);
			//玩家名字
			writeString(buf, this.playerName);
			//玩家等级
			writeInt(buf, this.playerLevel);
			//vip等级
			writeInt(buf, this.vipLevel);
			//经验
			writeInt(buf, this.exp);
			//体力
			writeInt(buf, this.health);
			//金钱
			writeInt(buf, this.gold);
			//灵子
			writeInt(buf, this.spirit);
			//魂玉
			writeInt(buf, this.soul);
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
			//账号id
			this.accountId = readLong(buf);
			//玩家id
			this.playerId = readLong(buf);
			//服务器id
			this.serverId = readInt(buf);
			//玩家名字
			this.playerName = readString(buf);
			//玩家等级
			this.playerLevel = readInt(buf);
			//vip等级
			this.vipLevel = readInt(buf);
			//经验
			this.exp = readInt(buf);
			//体力
			this.health = readInt(buf);
			//金钱
			this.gold = readInt(buf);
			//灵子
			this.spirit = readInt(buf);
			//魂玉
			this.soul = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 账号id
	 * @return 
	 */
	public Long getAccountId(){
		return accountId;
	}
	
	/**
	 * set 账号id
	 */
	public void setAccountId(Long accountId){
		this.accountId = accountId;
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
	 * get 服务器id
	 * @return 
	 */
	public Integer getServerId(){
		return serverId;
	}
	
	/**
	 * set 服务器id
	 */
	public void setServerId(Integer serverId){
		this.serverId = serverId;
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
	 * get vip等级
	 * @return 
	 */
	public Integer getVipLevel(){
		return vipLevel;
	}
	
	/**
	 * set vip等级
	 */
	public void setVipLevel(Integer vipLevel){
		this.vipLevel = vipLevel;
	}
	
	/**
	 * get 经验
	 * @return 
	 */
	public Integer getExp(){
		return exp;
	}
	
	/**
	 * set 经验
	 */
	public void setExp(Integer exp){
		this.exp = exp;
	}
	
	/**
	 * get 体力
	 * @return 
	 */
	public Integer getHealth(){
		return health;
	}
	
	/**
	 * set 体力
	 */
	public void setHealth(Integer health){
		this.health = health;
	}
	
	/**
	 * get 金钱
	 * @return 
	 */
	public Integer getGold(){
		return gold;
	}
	
	/**
	 * set 金钱
	 */
	public void setGold(Integer gold){
		this.gold = gold;
	}
	
	/**
	 * get 灵子
	 * @return 
	 */
	public Integer getSpirit(){
		return spirit;
	}
	
	/**
	 * set 灵子
	 */
	public void setSpirit(Integer spirit){
		this.spirit = spirit;
	}
	
	/**
	 * get 魂玉
	 * @return 
	 */
	public Integer getSoul(){
		return soul;
	}
	
	/**
	 * set 魂玉
	 */
	public void setSoul(Integer soul){
		this.soul = soul;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//账号id
		buf.append("accountId:" + accountId +",");
		//玩家id
		buf.append("playerId:" + playerId +",");
		//服务器id
		buf.append("serverId:" + serverId +",");
		//玩家名字
		if(this.playerName!=null) buf.append("playerName:" + playerName.toString() +",");
		//玩家等级
		buf.append("playerLevel:" + playerLevel +",");
		//vip等级
		buf.append("vipLevel:" + vipLevel +",");
		//经验
		buf.append("exp:" + exp +",");
		//体力
		buf.append("health:" + health +",");
		//金钱
		buf.append("gold:" + gold +",");
		//灵子
		buf.append("spirit:" + spirit +",");
		//魂玉
		buf.append("soul:" + soul +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}