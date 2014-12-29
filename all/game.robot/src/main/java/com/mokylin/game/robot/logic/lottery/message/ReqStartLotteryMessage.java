package com.mokylin.game.robot.logic.lottery.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 抽奖请求消息
 */
public class ReqStartLotteryMessage extends Message{

	private static Logger log = Logger.getLogger(ReqStartLotteryMessage.class);
	
	//0：A消耗环单抽，1：A消耗环十连抽，2：B消耗魂玉单抽，3：B消耗魂玉十连抽，4：C消耗魂玉单抽
	private Integer type;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0：A消耗环单抽，1：A消耗环十连抽，2：B消耗魂玉单抽，3：B消耗魂玉十连抽，4：C消耗魂玉单抽
			writeInt(buf, this.type);
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
			//0：A消耗环单抽，1：A消耗环十连抽，2：B消耗魂玉单抽，3：B消耗魂玉十连抽，4：C消耗魂玉单抽
			this.type = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0：A消耗环单抽，1：A消耗环十连抽，2：B消耗魂玉单抽，3：B消耗魂玉十连抽，4：C消耗魂玉单抽
	 * @return 
	 */
	public Integer getType(){
		return type;
	}
	
	/**
	 * set 0：A消耗环单抽，1：A消耗环十连抽，2：B消耗魂玉单抽，3：B消耗魂玉十连抽，4：C消耗魂玉单抽
	 */
	public void setType(Integer type){
		this.type = type;
	}
	
	
	@Override
	public int getId() {
		return 212101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0：A消耗环单抽，1：A消耗环十连抽，2：B消耗魂玉单抽，3：B消耗魂玉十连抽，4：C消耗魂玉单抽
		buf.append("type:" + type +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}