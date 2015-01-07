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
public class ResStartSoulTrialMessage extends Message{

	private static Logger log = Logger.getLogger(ResStartSoulTrialMessage.class);
	
	//0：成功 1：等级不够
	private Integer success;
	//试炼id
	private Integer trialId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0：成功 1：等级不够
			writeInt(buf, this.success);
			//试炼id
			writeInt(buf, this.trialId);
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
			//0：成功 1：等级不够
			this.success = readInt(buf);
			//试炼id
			this.trialId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0：成功 1：等级不够
	 * @return 
	 */
	public Integer getSuccess(){
		return success;
	}
	
	/**
	 * set 0：成功 1：等级不够
	 */
	public void setSuccess(Integer success){
		this.success = success;
	}
	
	/**
	 * get 试炼id
	 * @return 
	 */
	public Integer getTrialId(){
		return trialId;
	}
	
	/**
	 * set 试炼id
	 */
	public void setTrialId(Integer trialId){
		this.trialId = trialId;
	}
	
	
	@Override
	public int getId() {
		return 204103;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0：成功 1：等级不够
		buf.append("success:" + success +",");
		//试炼id
		buf.append("trialId:" + trialId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}