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
public class ResSigninMessage extends Message{

	private static Logger log = Logger.getLogger(ResSigninMessage.class);
	
	//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
	private Integer msg;
	//签到类型（0：普通签到，1：补签）
	private Integer type;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
			writeInt(buf, this.msg);
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
			//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
			this.msg = readInt(buf);
			//签到类型（0：普通签到，1：补签）
			this.type = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
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
		return 305101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//灵魂能力升级结果消息id（0：成功，非0：失败的消息id）
		buf.append("msg:" + msg +",");
		//签到类型（0：普通签到，1：补签）
		buf.append("type:" + type +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}