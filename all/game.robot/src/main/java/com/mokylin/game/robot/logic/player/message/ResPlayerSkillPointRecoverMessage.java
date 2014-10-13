package com.mokylin.game.robot.logic.player.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 玩家技能点恢复消息
 */
public class ResPlayerSkillPointRecoverMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerSkillPointRecoverMessage.class);
	
	//当前技能点数
	private Integer skillPoint;
	//距离下次恢复的秒数
	private Integer cdTime;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//当前技能点数
			writeInt(buf, this.skillPoint);
			//距离下次恢复的秒数
			writeInt(buf, this.cdTime);
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
			//当前技能点数
			this.skillPoint = readInt(buf);
			//距离下次恢复的秒数
			this.cdTime = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 当前技能点数
	 * @return 
	 */
	public Integer getSkillPoint(){
		return skillPoint;
	}
	
	/**
	 * set 当前技能点数
	 */
	public void setSkillPoint(Integer skillPoint){
		this.skillPoint = skillPoint;
	}
	
	/**
	 * get 距离下次恢复的秒数
	 * @return 
	 */
	public Integer getCdTime(){
		return cdTime;
	}
	
	/**
	 * set 距离下次恢复的秒数
	 */
	public void setCdTime(Integer cdTime){
		this.cdTime = cdTime;
	}
	
	
	@Override
	public int getId() {
		return 105109;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//当前技能点数
		buf.append("skillPoint:" + skillPoint +",");
		//距离下次恢复的秒数
		buf.append("cdTime:" + cdTime +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}