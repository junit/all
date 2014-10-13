package com.mokylin.game.robot.logic.mail.bean;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.mail.bean.*;
import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 邮件信息
 */
public class MailInfo extends Bean {

	private static Logger log = Logger.getLogger(MailInfo.class);
	
	//邮件id
	private Long mailId;
	
	//邮件发送日期
	private Long sendTime;
	
	//邮件有效的毫秒数
	private Long validTime;
	
	//邮件类型，1-活动邮件，2-竞技场，3-地狱蝶
	private Integer mailType;
	
	//邮件删除方式，0-读完不删除，1-读完删除
	private Integer deleteType;
	
	//发送者名字
	private String senderName;
	
	//邮件标题
	private String subject;
	
	//邮件内容
	private String content;
	
	//邮件附件
	private List<com.mokylin.game.robot.logic.item.bean.ItemInfo> attachInfo = new ArrayList<>();
	//邮件状态，0：未读 1：已读 2：已取
	private Integer status;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//邮件id
			writeLong(buf, this.mailId);
			//邮件发送日期
			writeLong(buf, this.sendTime);
			//邮件有效的毫秒数
			writeLong(buf, this.validTime);
			//邮件类型，1-活动邮件，2-竞技场，3-地狱蝶
			writeInt(buf, this.mailType);
			//邮件删除方式，0-读完不删除，1-读完删除
			writeInt(buf, this.deleteType);
			//发送者名字
			writeString(buf, this.senderName);
			//邮件标题
			writeString(buf, this.subject);
			//邮件内容
			writeString(buf, this.content);
			//邮件附件
			writeShort(buf, (short)attachInfo.size());
			for (int i = 0; i < attachInfo.size(); i++) {
				writeBean(buf, attachInfo.get(i));
			}
			//邮件状态，0：未读 1：已读 2：已取
			writeInt(buf, this.status);
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
			//邮件发送日期
			this.sendTime = readLong(buf);
			//邮件有效的毫秒数
			this.validTime = readLong(buf);
			//邮件类型，1-活动邮件，2-竞技场，3-地狱蝶
			this.mailType = readInt(buf);
			//邮件删除方式，0-读完不删除，1-读完删除
			this.deleteType = readInt(buf);
			//发送者名字
			this.senderName = readString(buf);
			//邮件标题
			this.subject = readString(buf);
			//邮件内容
			this.content = readString(buf);
			//邮件附件
			int attachInfo_length = readShort(buf);
			for (int i = 0; i < attachInfo_length; i++) {
				attachInfo.add((com.mokylin.game.robot.logic.item.bean.ItemInfo)readBean(buf, com.mokylin.game.robot.logic.item.bean.ItemInfo.class));
			}
			//邮件状态，0：未读 1：已读 2：已取
			this.status = readInt(buf);
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
	
	/**
	 * get 邮件发送日期
	 * @return 
	 */
	public Long getSendTime(){
		return sendTime;
	}
	
	/**
	 * set 邮件发送日期
	 */
	public void setSendTime(Long sendTime){
		this.sendTime = sendTime;
	}
	
	/**
	 * get 邮件有效的毫秒数
	 * @return 
	 */
	public Long getValidTime(){
		return validTime;
	}
	
	/**
	 * set 邮件有效的毫秒数
	 */
	public void setValidTime(Long validTime){
		this.validTime = validTime;
	}
	
	/**
	 * get 邮件类型，1-活动邮件，2-竞技场，3-地狱蝶
	 * @return 
	 */
	public Integer getMailType(){
		return mailType;
	}
	
	/**
	 * set 邮件类型，1-活动邮件，2-竞技场，3-地狱蝶
	 */
	public void setMailType(Integer mailType){
		this.mailType = mailType;
	}
	
	/**
	 * get 邮件删除方式，0-读完不删除，1-读完删除
	 * @return 
	 */
	public Integer getDeleteType(){
		return deleteType;
	}
	
	/**
	 * set 邮件删除方式，0-读完不删除，1-读完删除
	 */
	public void setDeleteType(Integer deleteType){
		this.deleteType = deleteType;
	}
	
	/**
	 * get 发送者名字
	 * @return 
	 */
	public String getSenderName(){
		return senderName;
	}
	
	/**
	 * set 发送者名字
	 */
	public void setSenderName(String senderName){
		this.senderName = senderName;
	}
	
	/**
	 * get 邮件标题
	 * @return 
	 */
	public String getSubject(){
		return subject;
	}
	
	/**
	 * set 邮件标题
	 */
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	/**
	 * get 邮件内容
	 * @return 
	 */
	public String getContent(){
		return content;
	}
	
	/**
	 * set 邮件内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	
	/**
	 * get 邮件附件
	 * @return 
	 */
	public List<com.mokylin.game.robot.logic.item.bean.ItemInfo> getAttachInfo(){
		return attachInfo;
	}
	
	/**
	 * set 邮件附件
	 */
	public void setAttachInfo(List<com.mokylin.game.robot.logic.item.bean.ItemInfo> attachInfo){
		this.attachInfo = attachInfo;
	}
	
	/**
	 * get 邮件状态，0：未读 1：已读 2：已取
	 * @return 
	 */
	public Integer getStatus(){
		return status;
	}
	
	/**
	 * set 邮件状态，0：未读 1：已读 2：已取
	 */
	public void setStatus(Integer status){
		this.status = status;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//邮件id
		buf.append("mailId:" + mailId +",");
		//邮件发送日期
		buf.append("sendTime:" + sendTime +",");
		//邮件有效的毫秒数
		buf.append("validTime:" + validTime +",");
		//邮件类型，1-活动邮件，2-竞技场，3-地狱蝶
		buf.append("mailType:" + mailType +",");
		//邮件删除方式，0-读完不删除，1-读完删除
		buf.append("deleteType:" + deleteType +",");
		//发送者名字
		if(this.senderName!=null) buf.append("senderName:" + senderName.toString() +",");
		//邮件标题
		if(this.subject!=null) buf.append("subject:" + subject.toString() +",");
		//邮件内容
		if(this.content!=null) buf.append("content:" + content.toString() +",");
		//邮件附件
		buf.append("attachInfo:{");
		for (int i = 0; i < attachInfo.size(); i++) {
			buf.append(attachInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//邮件状态，0：未读 1：已读 2：已取
		buf.append("status:" + status +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}