package com.mokylin.game.robot.logic.signin.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回端请求签到结果消息
 */
public class ResResetSigninMessage extends Message{

	private static Logger log = Logger.getLogger(ResResetSigninMessage.class);
	
	//重置签到类型（0：重置今日为未签到，1：重置当月签到次数为0）
	private Integer type;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//重置签到类型（0：重置今日为未签到，1：重置当月签到次数为0）
			writeInt(buf, this.type);
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
			//重置签到类型（0：重置今日为未签到，1：重置当月签到次数为0）
			this.type = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 重置签到类型（0：重置今日为未签到，1：重置当月签到次数为0）
	 * @return 
	 */
	public Integer getType(){
		return type;
	}
	
	/**
	 * set 重置签到类型（0：重置今日为未签到，1：重置当月签到次数为0）
	 */
	public void setType(Integer type){
		this.type = type;
	}
	
	
	@Override
	public int getId() {
		return 305102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//重置签到类型（0：重置今日为未签到，1：重置当月签到次数为0）
		buf.append("type:" + type +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}