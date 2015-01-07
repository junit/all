package com.mokylin.game.server.logic.lottery.message;


import com.mokylin.game.server.logic.lottery.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 同步抽奖系统信息消息
 */
public class ResSyncLotteryInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResSyncLotteryInfoMessage.class);
	
	//
	private LotteryInfo lotteryInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//
			writeBean(buf, this.lotteryInfo);
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
			//
			this.lotteryInfo = (LotteryInfo)readBean(buf, LotteryInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 
	 * @return 
	 */
	public LotteryInfo getLotteryInfo(){
		return lotteryInfo;
	}
	
	/**
	 * set 
	 */
	public void setLotteryInfo(LotteryInfo lotteryInfo){
		this.lotteryInfo = lotteryInfo;
	}
	
	
	@Override
	public int getId() {
		return 212201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//
		if(this.lotteryInfo!=null) buf.append("lotteryInfo:" + lotteryInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}