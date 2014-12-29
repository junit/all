package com.mokylin.game.robot.logic.millionluck.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 前端请求招财消息
 */
public class ReqLuckMessage extends Message{

	private static Logger log = Logger.getLogger(ReqLuckMessage.class);
	
	//卡片序号（1到7）
	private Integer cardNo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//卡片序号（1到7）
			writeInt(buf, this.cardNo);
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
			//卡片序号（1到7）
			this.cardNo = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 卡片序号（1到7）
	 * @return 
	 */
	public Integer getCardNo(){
		return cardNo;
	}
	
	/**
	 * set 卡片序号（1到7）
	 */
	public void setCardNo(Integer cardNo){
		this.cardNo = cardNo;
	}
	
	
	@Override
	public int getId() {
		return 302201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//卡片序号（1到7）
		buf.append("cardNo:" + cardNo +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}