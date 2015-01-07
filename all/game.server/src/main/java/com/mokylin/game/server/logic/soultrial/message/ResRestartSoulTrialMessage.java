package com.mokylin.game.server.logic.soultrial.message;


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
public class ResRestartSoulTrialMessage extends Message{

	private static Logger log = Logger.getLogger(ResRestartSoulTrialMessage.class);
	
	//0：成功 1：可用剩余次数不够
	private Integer success;
	//剩余次数
	private Integer count;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0：成功 1：可用剩余次数不够
			writeInt(buf, this.success);
			//剩余次数
			writeInt(buf, this.count);
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
			//0：成功 1：可用剩余次数不够
			this.success = readInt(buf);
			//剩余次数
			this.count = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0：成功 1：可用剩余次数不够
	 * @return 
	 */
	public Integer getSuccess(){
		return success;
	}
	
	/**
	 * set 0：成功 1：可用剩余次数不够
	 */
	public void setSuccess(Integer success){
		this.success = success;
	}
	
	/**
	 * get 剩余次数
	 * @return 
	 */
	public Integer getCount(){
		return count;
	}
	
	/**
	 * set 剩余次数
	 */
	public void setCount(Integer count){
		this.count = count;
	}
	
	
	@Override
	public int getId() {
		return 204102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0：成功 1：可用剩余次数不够
		buf.append("success:" + success +",");
		//剩余次数
		buf.append("count:" + count +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}