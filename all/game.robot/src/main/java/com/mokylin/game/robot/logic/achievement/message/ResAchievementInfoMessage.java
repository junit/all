package com.mokylin.game.robot.logic.achievement.message;


import com.mokylin.game.robot.logic.achievement.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 成就信息消息
 */
public class ResAchievementInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResAchievementInfoMessage.class);
	
	//成就信息
	private AchievementInfo achieveInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//成就信息
			writeBean(buf, this.achieveInfo);
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
			//成就信息
			this.achieveInfo = (AchievementInfo)readBean(buf, AchievementInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 成就信息
	 * @return 
	 */
	public AchievementInfo getAchieveInfo(){
		return achieveInfo;
	}
	
	/**
	 * set 成就信息
	 */
	public void setAchieveInfo(AchievementInfo achieveInfo){
		this.achieveInfo = achieveInfo;
	}
	
	
	@Override
	public int getId() {
		return 210101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//成就信息
		if(this.achieveInfo!=null) buf.append("achieveInfo:" + achieveInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}