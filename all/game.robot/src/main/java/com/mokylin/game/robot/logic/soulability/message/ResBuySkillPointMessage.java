package com.mokylin.game.robot.logic.soulability.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回购买技能点请求消息
 */
public class ResBuySkillPointMessage extends Message{

	private static Logger log = Logger.getLogger(ResBuySkillPointMessage.class);
	
	//最新技能点数
	private Integer skillPoint;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//最新技能点数
			writeInt(buf, this.skillPoint);
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
			//最新技能点数
			this.skillPoint = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 最新技能点数
	 * @return 
	 */
	public Integer getSkillPoint(){
		return skillPoint;
	}
	
	/**
	 * set 最新技能点数
	 */
	public void setSkillPoint(Integer skillPoint){
		this.skillPoint = skillPoint;
	}
	
	
	@Override
	public int getId() {
		return 304104;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//最新技能点数
		buf.append("skillPoint:" + skillPoint +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}