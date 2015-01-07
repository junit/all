package com.mokylin.game.server.logic.millionluck.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 招财记录信息
 */
public class LuckRecordInfo extends Bean {

	private static Logger log = Logger.getLogger(LuckRecordInfo.class);
	
	//卡片序号（1到7）
	private Integer cardNo;
	
	//卡片被翻出的数字（1到9）
	private Integer cardNum;
	
	//翻牌次序(第几次翻牌)
	private Integer sequence;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//卡片序号（1到7）
			writeInt(buf, this.cardNo);
			//卡片被翻出的数字（1到9）
			writeInt(buf, this.cardNum);
			//翻牌次序(第几次翻牌)
			writeInt(buf, this.sequence);
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
			//卡片被翻出的数字（1到9）
			this.cardNum = readInt(buf);
			//翻牌次序(第几次翻牌)
			this.sequence = readInt(buf);
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
	
	/**
	 * get 卡片被翻出的数字（1到9）
	 * @return 
	 */
	public Integer getCardNum(){
		return cardNum;
	}
	
	/**
	 * set 卡片被翻出的数字（1到9）
	 */
	public void setCardNum(Integer cardNum){
		this.cardNum = cardNum;
	}
	
	/**
	 * get 翻牌次序(第几次翻牌)
	 * @return 
	 */
	public Integer getSequence(){
		return sequence;
	}
	
	/**
	 * set 翻牌次序(第几次翻牌)
	 */
	public void setSequence(Integer sequence){
		this.sequence = sequence;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//卡片序号（1到7）
		buf.append("cardNo:" + cardNo +",");
		//卡片被翻出的数字（1到9）
		buf.append("cardNum:" + cardNum +",");
		//翻牌次序(第几次翻牌)
		buf.append("sequence:" + sequence +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}