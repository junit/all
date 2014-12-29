package com.mokylin.game.robot.logic.butterfly.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 结束地狱蝶回复消息
 */
public class ResEndButterflyMessage extends Message{

	private static Logger log = Logger.getLogger(ResEndButterflyMessage.class);
	
	//0：抢夺成功，1：抢夺失败
	private Integer result;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0：抢夺成功，1：抢夺失败
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
			//0：抢夺成功，1：抢夺失败
			this.result = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0：抢夺成功，1：抢夺失败
	 * @return 
	 */
	public Integer getResult(){
		return result;
	}
	
	/**
	 * set 0：抢夺成功，1：抢夺失败
	 */
	public void setResult(Integer result){
		this.result = result;
	}
	
	
	@Override
	public int getId() {
		return 211203;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0：抢夺成功，1：抢夺失败
		buf.append("result:" + result +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}