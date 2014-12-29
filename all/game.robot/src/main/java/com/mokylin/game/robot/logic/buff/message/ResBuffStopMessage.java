package com.mokylin.game.robot.logic.buff.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * Buff停止消息
 */
public class ResBuffStopMessage extends Message{

	private static Logger log = Logger.getLogger(ResBuffStopMessage.class);
	
	//buff id
	private Integer buffId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//buff id
			writeInt(buf, this.buffId);
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
			//buff id
			this.buffId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get buff id
	 * @return 
	 */
	public Integer getBuffId(){
		return buffId;
	}
	
	/**
	 * set buff id
	 */
	public void setBuffId(Integer buffId){
		this.buffId = buffId;
	}
	
	
	@Override
	public int getId() {
		return 203102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//buff id
		buf.append("buffId:" + buffId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}