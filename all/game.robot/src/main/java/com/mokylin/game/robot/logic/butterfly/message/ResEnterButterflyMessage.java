package com.mokylin.game.robot.logic.butterfly.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 进入地狱蝶回复消息
 */
public class ResEnterButterflyMessage extends Message{

	private static Logger log = Logger.getLogger(ResEnterButterflyMessage.class);
	
	//0：成功，1：未开放，2：等级不够
	private Integer result;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0：成功，1：未开放，2：等级不够
			writeInt(buf, this.result);
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
			//0：成功，1：未开放，2：等级不够
			this.result = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0：成功，1：未开放，2：等级不够
	 * @return 
	 */
	public Integer getResult(){
		return result;
	}
	
	/**
	 * set 0：成功，1：未开放，2：等级不够
	 */
	public void setResult(Integer result){
		this.result = result;
	}
	
	
	@Override
	public int getId() {
		return 211201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0：成功，1：未开放，2：等级不够
		buf.append("result:" + result +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}