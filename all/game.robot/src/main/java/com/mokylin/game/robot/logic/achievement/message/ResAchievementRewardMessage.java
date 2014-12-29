package com.mokylin.game.robot.logic.achievement.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 成就领奖答复消息
 */
public class ResAchievementRewardMessage extends Message{

	private static Logger log = Logger.getLogger(ResAchievementRewardMessage.class);
	
	//成就Id
	private Integer achieveId;
	//0：成功，1：未找到该id的成就，2：成就未完成，3：已领取过奖励
	private Integer result;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//成就Id
			writeInt(buf, this.achieveId);
			//0：成功，1：未找到该id的成就，2：成就未完成，3：已领取过奖励
			writeInt(buf, this.result);
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
			//0：成功，1：未找到该id的成就，2：成就未完成，3：已领取过奖励
			this.result = readInt(buf);
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
	
	/**
	 * get 0：成功，1：未找到该id的成就，2：成就未完成，3：已领取过奖励
	 * @return 
	 */
	public Integer getResult(){
		return result;
	}
	
	/**
	 * set 0：成功，1：未找到该id的成就，2：成就未完成，3：已领取过奖励
	 */
	public void setResult(Integer result){
		this.result = result;
	}
	
	
	@Override
	public int getId() {
		return 210102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//成就Id
		buf.append("achieveId:" + achieveId +",");
		//0：成功，1：未找到该id的成就，2：成就未完成，3：已领取过奖励
		buf.append("result:" + result +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}