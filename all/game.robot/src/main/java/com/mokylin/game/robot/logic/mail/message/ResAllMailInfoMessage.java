package com.mokylin.game.robot.logic.mail.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.mail.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 全部邮件消息
 */
public class ResAllMailInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResAllMailInfoMessage.class);
	
	//邮件具体信息
	private List<MailInfo> mailInfo = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//邮件具体信息
			writeShort(buf, (short)mailInfo.size());
			for (int i = 0; i < mailInfo.size(); i++) {
				writeBean(buf, mailInfo.get(i));
			}
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
			//邮件具体信息
			int mailInfo_length = readShort(buf);
			for (int i = 0; i < mailInfo_length; i++) {
				mailInfo.add((MailInfo)readBean(buf, MailInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 邮件具体信息
	 * @return 
	 */
	public List<MailInfo> getMailInfo(){
		return mailInfo;
	}
	
	/**
	 * set 邮件具体信息
	 */
	public void setMailInfo(List<MailInfo> mailInfo){
		this.mailInfo = mailInfo;
	}
	
	
	@Override
	public int getId() {
		return 500105;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//邮件具体信息
		buf.append("mailInfo:{");
		for (int i = 0; i < mailInfo.size(); i++) {
			buf.append(mailInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}