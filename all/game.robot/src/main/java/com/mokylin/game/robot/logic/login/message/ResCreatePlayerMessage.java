package com.mokylin.game.robot.logic.login.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 创建玩家信息消息
 */
public class ResCreatePlayerMessage extends Message{

	private static Logger log = Logger.getLogger(ResCreatePlayerMessage.class);
	
	
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
		return 100101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}