package com.mokylin.game.robot.logic.achievement.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 成就领奖请求消息
 */
public class ReqAchievementRewardMessage extends Message{

	private static Logger log = Logger.getLogger(ReqAchievementRewardMessage.class);
	
	//成就Id
	private Integer achieveId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//成就Id
			writeInt(buf, this.achieveId);
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
			//成就Id
			this.achieveId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 成就Id
	 * @return 
	 */
	public Integer getAchieveId(){
		return achieveId;
	}
	
	/**
	 * set 成就Id
	 */
	public void setAchieveId(Integer achieveId){
		this.achieveId = achieveId;
	}
	
	
	@Override
	public int getId() {
		return 210201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//成就Id
		buf.append("achieveId:" + achieveId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}