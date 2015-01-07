package com.mokylin.game.server.logic.level.message;


import com.mokylin.game.server.logic.level.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回通关结果信息消息
 */
public class ResClearanceInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResClearanceInfoMessage.class);
	
	//通关信息
	private ClearanceInfo clearanceInfo;
	//通关奖励
	private LevelRewardInfo levelRewardInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//通关信息
			writeBean(buf, this.clearanceInfo);
			//通关奖励
			writeBean(buf, this.levelRewardInfo);
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
			//通关信息
			this.clearanceInfo = (ClearanceInfo)readBean(buf, ClearanceInfo.class);
			//通关奖励
			this.levelRewardInfo = (LevelRewardInfo)readBean(buf, LevelRewardInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 通关信息
	 * @return 
	 */
	public ClearanceInfo getClearanceInfo(){
		return clearanceInfo;
	}
	
	/**
	 * set 通关信息
	 */
	public void setClearanceInfo(ClearanceInfo clearanceInfo){
		this.clearanceInfo = clearanceInfo;
	}
	
	/**
	 * get 通关奖励
	 * @return 
	 */
	public LevelRewardInfo getLevelRewardInfo(){
		return levelRewardInfo;
	}
	
	/**
	 * set 通关奖励
	 */
	public void setLevelRewardInfo(LevelRewardInfo levelRewardInfo){
		this.levelRewardInfo = levelRewardInfo;
	}
	
	
	@Override
	public int getId() {
		return 102101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//通关信息
		if(this.clearanceInfo!=null) buf.append("clearanceInfo:" + clearanceInfo.toString() +",");
		//通关奖励
		if(this.levelRewardInfo!=null) buf.append("levelRewardInfo:" + levelRewardInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}