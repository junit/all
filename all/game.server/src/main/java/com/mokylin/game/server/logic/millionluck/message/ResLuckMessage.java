package com.mokylin.game.server.logic.millionluck.message;


import com.mokylin.game.server.logic.millionluck.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回前端请求招财结果消息
 */
public class ResLuckMessage extends Message{

	private static Logger log = Logger.getLogger(ResLuckMessage.class);
	
	//招财结果消息Id(0：成功,非0：失败的消息Id)
	private Integer msg;
	//招财记录
	private LuckRecordInfo luckRecord;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//招财结果消息Id(0：成功,非0：失败的消息Id)
			writeInt(buf, this.msg);
			//招财记录
			writeBean(buf, this.luckRecord);
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
			//招财结果消息Id(0：成功,非0：失败的消息Id)
			this.msg = readInt(buf);
			//招财记录
			this.luckRecord = (LuckRecordInfo)readBean(buf, LuckRecordInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 招财结果消息Id(0：成功,非0：失败的消息Id)
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 招财结果消息Id(0：成功,非0：失败的消息Id)
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
	}
	
	/**
	 * get 招财记录
	 * @return 
	 */
	public LuckRecordInfo getLuckRecord(){
		return luckRecord;
	}
	
	/**
	 * set 招财记录
	 */
	public void setLuckRecord(LuckRecordInfo luckRecord){
		this.luckRecord = luckRecord;
	}
	
	
	@Override
	public int getId() {
		return 302101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//招财结果消息Id(0：成功,非0：失败的消息Id)
		buf.append("msg:" + msg +",");
		//招财记录
		if(this.luckRecord!=null) buf.append("luckRecord:" + luckRecord.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}