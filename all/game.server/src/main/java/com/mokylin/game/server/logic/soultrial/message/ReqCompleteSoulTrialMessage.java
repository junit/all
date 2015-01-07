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
public class ReqCompleteSoulTrialMessage extends Message{

	private static Logger log = Logger.getLogger(ReqCompleteSoulTrialMessage.class);
	
	//是否通过
	private Integer isSuccess;
	//试炼id
	private Integer trialId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//是否通过
			writeInt(buf, this.isSuccess);
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
			//是否通过
			this.isSuccess = readInt(buf);
			//试炼id
			this.trialId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 是否通过
	 * @return 
	 */
	public Integer getIsSuccess(){
		return isSuccess;
	}
	
	/**
	 * set 是否通过
	 */
	public void setIsSuccess(Integer isSuccess){
		this.isSuccess = isSuccess;
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
		return 204202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//是否通过
		buf.append("isSuccess:" + isSuccess +",");
		//试炼id
		buf.append("trialId:" + trialId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}