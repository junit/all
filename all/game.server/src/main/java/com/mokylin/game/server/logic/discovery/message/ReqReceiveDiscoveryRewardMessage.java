package com.mokylin.game.server.logic.discovery.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 前端请求领取探索奖励(真正结束探索)消息
 */
public class ReqReceiveDiscoveryRewardMessage extends Message{

	private static Logger log = Logger.getLogger(ReqReceiveDiscoveryRewardMessage.class);
	
	
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
		return 303202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}