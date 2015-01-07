package com.mokylin.game.server.logic.signin.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 前端请求签到消息
 */
public class ReqSigninMessage extends Message{

	private static Logger log = Logger.getLogger(ReqSigninMessage.class);
	
	//签到类型（0：普通签到，1：补签）
	private Integer type;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//签到类型（0：普通签到，1：补签）
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
			//签到类型（0：普通签到，1：补签）
			this.type = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 签到类型（0：普通签到，1：补签）
	 * @return 
	 */
	public Integer getType(){
		return type;
	}
	
	/**
	 * set 签到类型（0：普通签到，1：补签）
	 */
	public void setType(Integer type){
		this.type = type;
	}
	
	
	@Override
	public int getId() {
		return 305201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//签到类型（0：普通签到，1：补签）
		buf.append("type:" + type +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}