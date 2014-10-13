package com.mokylin.game.robot.logic.spa.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 前端请求使用活力结果消息消息
 */
public class ResUseVitalityMessage extends Message{

	private static Logger log = Logger.getLogger(ResUseVitalityMessage.class);
	
	//前端请求使用活力结果消息Id(0：成功,非0：失败的消息Id)
	private Integer msg;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//前端请求使用活力结果消息Id(0：成功,非0：失败的消息Id)
			writeInt(buf, this.msg);
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
			//前端请求使用活力结果消息Id(0：成功,非0：失败的消息Id)
			this.msg = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 前端请求使用活力结果消息Id(0：成功,非0：失败的消息Id)
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 前端请求使用活力结果消息Id(0：成功,非0：失败的消息Id)
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
	}
	
	
	@Override
	public int getId() {
		return 300105;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//前端请求使用活力结果消息Id(0：成功,非0：失败的消息Id)
		buf.append("msg:" + msg +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}