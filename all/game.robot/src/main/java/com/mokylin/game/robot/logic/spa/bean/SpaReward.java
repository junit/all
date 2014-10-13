package com.mokylin.game.robot.logic.spa.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 温泉奖励
 */
public class SpaReward extends Bean {

	private static Logger log = Logger.getLogger(SpaReward.class);
	
	//玩家角色Id
	private Integer playerRoleId;
	
	//好友角色Id
	private Integer friendRoleId;
	
	//系统角色Id
	private Integer systemRoleId;
	
	//特殊组合Id
	private Integer SpecialGroupId;
	
	//灵魂碎片Id
	private Integer soulShardId;
	
	//灵魂碎片奖励数量
	private Integer soulShardNum;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//玩家角色Id
			writeInt(buf, this.playerRoleId);
			//好友角色Id
			writeInt(buf, this.friendRoleId);
			//系统角色Id
			writeInt(buf, this.systemRoleId);
			//特殊组合Id
			writeInt(buf, this.SpecialGroupId);
			//灵魂碎片Id
			writeInt(buf, this.soulShardId);
			//灵魂碎片奖励数量
			writeInt(buf, this.soulShardNum);
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
			//玩家角色Id
			this.playerRoleId = readInt(buf);
			//好友角色Id
			this.friendRoleId = readInt(buf);
			//系统角色Id
			this.systemRoleId = readInt(buf);
			//特殊组合Id
			this.SpecialGroupId = readInt(buf);
			//灵魂碎片Id
			this.soulShardId = readInt(buf);
			//灵魂碎片奖励数量
			this.soulShardNum = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 玩家角色Id
	 * @return 
	 */
	public Integer getPlayerRoleId(){
		return playerRoleId;
	}
	
	/**
	 * set 玩家角色Id
	 */
	public void setPlayerRoleId(Integer playerRoleId){
		this.playerRoleId = playerRoleId;
	}
	
	/**
	 * get 好友角色Id
	 * @return 
	 */
	public Integer getFriendRoleId(){
		return friendRoleId;
	}
	
	/**
	 * set 好友角色Id
	 */
	public void setFriendRoleId(Integer friendRoleId){
		this.friendRoleId = friendRoleId;
	}
	
	/**
	 * get 系统角色Id
	 * @return 
	 */
	public Integer getSystemRoleId(){
		return systemRoleId;
	}
	
	/**
	 * set 系统角色Id
	 */
	public void setSystemRoleId(Integer systemRoleId){
		this.systemRoleId = systemRoleId;
	}
	
	/**
	 * get 特殊组合Id
	 * @return 
	 */
	public Integer getSpecialGroupId(){
		return SpecialGroupId;
	}
	
	/**
	 * set 特殊组合Id
	 */
	public void setSpecialGroupId(Integer SpecialGroupId){
		this.SpecialGroupId = SpecialGroupId;
	}
	
	/**
	 * get 灵魂碎片Id
	 * @return 
	 */
	public Integer getSoulShardId(){
		return soulShardId;
	}
	
	/**
	 * set 灵魂碎片Id
	 */
	public void setSoulShardId(Integer soulShardId){
		this.soulShardId = soulShardId;
	}
	
	/**
	 * get 灵魂碎片奖励数量
	 * @return 
	 */
	public Integer getSoulShardNum(){
		return soulShardNum;
	}
	
	/**
	 * set 灵魂碎片奖励数量
	 */
	public void setSoulShardNum(Integer soulShardNum){
		this.soulShardNum = soulShardNum;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//玩家角色Id
		buf.append("playerRoleId:" + playerRoleId +",");
		//好友角色Id
		buf.append("friendRoleId:" + friendRoleId +",");
		//系统角色Id
		buf.append("systemRoleId:" + systemRoleId +",");
		//特殊组合Id
		buf.append("SpecialGroupId:" + SpecialGroupId +",");
		//灵魂碎片Id
		buf.append("soulShardId:" + soulShardId +",");
		//灵魂碎片奖励数量
		buf.append("soulShardNum:" + soulShardNum +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}