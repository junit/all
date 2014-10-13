package com.mokylin.game.robot.logic.skill.message;


import com.mokylin.game.robot.logic.skill.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 同步援护技能消息
 */
public class ResSkillAssistSkillMessage extends Message{

	private static Logger log = Logger.getLogger(ResSkillAssistSkillMessage.class);
	
	//技能信息
	private AssistSkillInfo info;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//技能信息
			writeBean(buf, this.info);
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
			//技能信息
			this.info = (AssistSkillInfo)readBean(buf, AssistSkillInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 技能信息
	 * @return 
	 */
	public AssistSkillInfo getInfo(){
		return info;
	}
	
	/**
	 * set 技能信息
	 */
	public void setInfo(AssistSkillInfo info){
		this.info = info;
	}
	
	
	@Override
	public int getId() {
		return 208102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//技能信息
		if(this.info!=null) buf.append("info:" + info.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}