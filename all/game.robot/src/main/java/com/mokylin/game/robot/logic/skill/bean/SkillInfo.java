package com.mokylin.game.robot.logic.skill.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 技能信息
 */
public class SkillInfo extends Bean {

	private static Logger log = Logger.getLogger(SkillInfo.class);
	
	//技能id
	private Integer skillId;
	
	//技能强化系数
	private Integer enhance;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//技能id
			writeInt(buf, this.skillId);
			//技能强化系数
			writeInt(buf, this.enhance);
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
			//技能id
			this.skillId = readInt(buf);
			//技能强化系数
			this.enhance = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 技能id
	 * @return 
	 */
	public Integer getSkillId(){
		return skillId;
	}
	
	/**
	 * set 技能id
	 */
	public void setSkillId(Integer skillId){
		this.skillId = skillId;
	}
	
	/**
	 * get 技能强化系数
	 * @return 
	 */
	public Integer getEnhance(){
		return enhance;
	}
	
	/**
	 * set 技能强化系数
	 */
	public void setEnhance(Integer enhance){
		this.enhance = enhance;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//技能id
		buf.append("skillId:" + skillId +",");
		//技能强化系数
		buf.append("enhance:" + enhance +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}