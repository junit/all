package com.mokylin.game.robot.logic.girl.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 交往消息
 */
public class ReqGirlDateMessage extends Message{

	private static Logger log = Logger.getLogger(ReqGirlDateMessage.class);
	
	//妹子id
	private Integer girlId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//妹子id
			writeInt(buf, this.girlId);
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
			//妹子id
			this.girlId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 妹子id
	 * @return 
	 */
	public Integer getGirlId(){
		return girlId;
	}
	
	/**
	 * set 妹子id
	 */
	public void setGirlId(Integer girlId){
		this.girlId = girlId;
	}
	
	
	@Override
	public int getId() {
		return 108202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//妹子id
		buf.append("girlId:" + girlId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}