package com.mokylin.game.server.logic.mail.message;


import com.mokylin.game.server.logic.mail.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 收到邮件消息
 */
public class ResReceiveMailMessage extends Message{

	private static Logger log = Logger.getLogger(ResReceiveMailMessage.class);
	
	//收到的邮件的具体信息
	private MailInfo mailInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//收到的邮件的具体信息
			writeBean(buf, this.mailInfo);
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
			//收到的邮件的具体信息
			this.mailInfo = (MailInfo)readBean(buf, MailInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 收到的邮件的具体信息
	 * @return 
	 */
	public MailInfo getMailInfo(){
		return mailInfo;
	}
	
	/**
	 * set 收到的邮件的具体信息
	 */
	public void setMailInfo(MailInfo mailInfo){
		this.mailInfo = mailInfo;
	}
	
	
	@Override
	public int getId() {
		return 500104;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//收到的邮件的具体信息
		if(this.mailInfo!=null) buf.append("mailInfo:" + mailInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}