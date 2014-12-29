package com.mokylin.game.robot.logic.girl.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 禁用援护技消息
 */
public class ReqGirlDisableAssistSkillMessage extends Message{

	private static Logger log = Logger.getLogger(ReqGirlDisableAssistSkillMessage.class);
	
	//援护技id
	private Integer assistSkill;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//援护技id
			writeInt(buf, this.assistSkill);
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
			//援护技id
			this.assistSkill = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 援护技id
	 * @return 
	 */
	public Integer getAssistSkill(){
		return assistSkill;
	}
	
	/**
	 * set 援护技id
	 */
	public void setAssistSkill(Integer assistSkill){
		this.assistSkill = assistSkill;
	}
	
	
	@Override
	public int getId() {
		return 108207;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//援护技id
		buf.append("assistSkill:" + assistSkill +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}