package com.mokylin.game.robot.logic.soultrial.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 消息
 */
public class ReqGetOneSoulTrialRewardMessage extends Message{

	private static Logger log = Logger.getLogger(ReqGetOneSoulTrialRewardMessage.class);
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
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
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	
	@Override
	public int getId() {
		return 204204;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}