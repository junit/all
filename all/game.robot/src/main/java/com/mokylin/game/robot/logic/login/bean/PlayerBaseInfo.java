package com.mokylin.game.robot.logic.login.bean;


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
	
	//通关星级总数
	private Integer star;
	
	//竞技场竞技币
	private Integer arena;
	
	//活力值
	private Integer vitality;
	
	//竞技场排名
	private Integer rank;
	
	//技能点数
	private Integer skillPoint;
	
	//已使用活力次数
	private Integer usedVitalityNum;
	
	//最大可使用活力次数
	private Integer maxVitalityNum;
	
	//今日是否已经招财(0:今日没有招财，非0：今日招过财)
	private Integer isLuckToday;
	
	//距离下次回复体力的秒数
	private Integer nextHealthTime;
	
	
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
			//通关星级总数
			writeInt(buf, this.star);
			//竞技场竞技币
			writeInt(buf, this.arena);
			//活力值
			writeInt(buf, this.vitality);
			//竞技场排名
			writeInt(buf, this.rank);
			//技能点数
			writeInt(buf, this.skillPoint);
			//已使用活力次数
			writeInt(buf, this.usedVitalityNum);
			//最大可使用活力次数
			writeInt(buf, this.maxVitalityNum);
			//今日是否已经招财(0:今日没有招财，非0：今日招过财)
			writeInt(buf, this.isLuckToday);
			//距离下次回复体力的秒数
			writeInt(buf, this.nextHealthTime);
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
			//通关星级总数
			this.star = readInt(buf);
			//竞技场竞技币
			this.arena = readInt(buf);
			//活力值
			this.vitality = readInt(buf);
			//竞技场排名
			this.rank = readInt(buf);
			//技能点数
			this.skillPoint = readInt(buf);
			//已使用活力次数
			this.usedVitalityNum = readInt(buf);
			//最大可使用活力次数
			this.maxVitalityNum = readInt(buf);
			//今日是否已经招财(0:今日没有招财，非0：今日招过财)
			this.isLuckToday = readInt(buf);
			//距离下次回复体力的秒数
			this.nextHealthTime = readInt(buf);
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
	
	/**
	 * get 通关星级总数
	 * @return 
	 */
	public Integer getStar(){
		return star;
	}
	
	/**
	 * set 通关星级总数
	 */
	public void setStar(Integer star){
		this.star = star;
	}
	
	/**
	 * get 竞技场竞技币
	 * @return 
	 */
	public Integer getArena(){
		return arena;
	}
	
	/**
	 * set 竞技场竞技币
	 */
	public void setArena(Integer arena){
		this.arena = arena;
	}
	
	/**
	 * get 活力值
	 * @return 
	 */
	public Integer getVitality(){
		return vitality;
	}
	
	/**
	 * set 活力值
	 */
	public void setVitality(Integer vitality){
		this.vitality = vitality;
	}
	
	/**
	 * get 竞技场排名
	 * @return 
	 */
	public Integer getRank(){
		return rank;
	}
	
	/**
	 * set 竞技场排名
	 */
	public void setRank(Integer rank){
		this.rank = rank;
	}
	
	/**
	 * get 技能点数
	 * @return 
	 */
	public Integer getSkillPoint(){
		return skillPoint;
	}
	
	/**
	 * set 技能点数
	 */
	public void setSkillPoint(Integer skillPoint){
		this.skillPoint = skillPoint;
	}
	
	/**
	 * get 已使用活力次数
	 * @return 
	 */
	public Integer getUsedVitalityNum(){
		return usedVitalityNum;
	}
	
	/**
	 * set 已使用活力次数
	 */
	public void setUsedVitalityNum(Integer usedVitalityNum){
		this.usedVitalityNum = usedVitalityNum;
	}
	
	/**
	 * get 最大可使用活力次数
	 * @return 
	 */
	public Integer getMaxVitalityNum(){
		return maxVitalityNum;
	}
	
	/**
	 * set 最大可使用活力次数
	 */
	public void setMaxVitalityNum(Integer maxVitalityNum){
		this.maxVitalityNum = maxVitalityNum;
	}
	
	/**
	 * get 今日是否已经招财(0:今日没有招财，非0：今日招过财)
	 * @return 
	 */
	public Integer getIsLuckToday(){
		return isLuckToday;
	}
	
	/**
	 * set 今日是否已经招财(0:今日没有招财，非0：今日招过财)
	 */
	public void setIsLuckToday(Integer isLuckToday){
		this.isLuckToday = isLuckToday;
	}
	
	/**
	 * get 距离下次回复体力的秒数
	 * @return 
	 */
	public Integer getNextHealthTime(){
		return nextHealthTime;
	}
	
	/**
	 * set 距离下次回复体力的秒数
	 */
	public void setNextHealthTime(Integer nextHealthTime){
		this.nextHealthTime = nextHealthTime;
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
		//通关星级总数
		buf.append("star:" + star +",");
		//竞技场竞技币
		buf.append("arena:" + arena +",");
		//活力值
		buf.append("vitality:" + vitality +",");
		//竞技场排名
		buf.append("rank:" + rank +",");
		//技能点数
		buf.append("skillPoint:" + skillPoint +",");
		//已使用活力次数
		buf.append("usedVitalityNum:" + usedVitalityNum +",");
		//最大可使用活力次数
		buf.append("maxVitalityNum:" + maxVitalityNum +",");
		//今日是否已经招财(0:今日没有招财，非0：今日招过财)
		buf.append("isLuckToday:" + isLuckToday +",");
		//距离下次回复体力的秒数
		buf.append("nextHealthTime:" + nextHealthTime +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}