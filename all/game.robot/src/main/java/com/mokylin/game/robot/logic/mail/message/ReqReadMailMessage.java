package com.mokylin.game.robot.logic.mail.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 读邮件请求消息
 */
public class ReqReadMailMessage extends Message{

	private static Logger log = Logger.getLogger(ReqReadMailMessage.class);
	
	//邮件id
	private Long mailId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//邮件id
			writeLong(buf, this.mailId);
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
			//邮件id
			this.mailId = readLong(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 邮件id
	 * @return 
	 */
	public Long getMailId(){
		return mailId;
	}
	
	/**
	 * set 邮件id
	 */
	public void setMailId(Long mailId){
		this.mailId = mailId;
	}
	
	
	@Override
	public int getId() {
		return 500201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//邮件id
		buf.append("mailId:" + mailId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}