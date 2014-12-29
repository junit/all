package com.mokylin.game.robot.logic.butterfly.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 回复地狱蝶是否开启消息
 */
public class ResIsButterflyOpenMessage extends Message{

	private static Logger log = Logger.getLogger(ResIsButterflyOpenMessage.class);
	
	//地狱蝶是否已开启，0-未开启，1-已开启
	private Integer isOpen;
	//未开启时，到开启剩余的秒数，已开启时，此参数为0
	private Integer waitSeconds;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//地狱蝶是否已开启，0-未开启，1-已开启
			writeInt(buf, this.isOpen);
			//未开启时，到开启剩余的秒数，已开启时，此参数为0
			writeInt(buf, this.waitSeconds);
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
			//地狱蝶是否已开启，0-未开启，1-已开启
			this.isOpen = readInt(buf);
			//未开启时，到开启剩余的秒数，已开启时，此参数为0
			this.waitSeconds = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 地狱蝶是否已开启，0-未开启，1-已开启
	 * @return 
	 */
	public Integer getIsOpen(){
		return isOpen;
	}
	
	/**
	 * set 地狱蝶是否已开启，0-未开启，1-已开启
	 */
	public void setIsOpen(Integer isOpen){
		this.isOpen = isOpen;
	}
	
	/**
	 * get 未开启时，到开启剩余的秒数，已开启时，此参数为0
	 * @return 
	 */
	public Integer getWaitSeconds(){
		return waitSeconds;
	}
	
	/**
	 * set 未开启时，到开启剩余的秒数，已开启时，此参数为0
	 */
	public void setWaitSeconds(Integer waitSeconds){
		this.waitSeconds = waitSeconds;
	}
	
	
	@Override
	public int getId() {
		return 211209;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//地狱蝶是否已开启，0-未开启，1-已开启
		buf.append("isOpen:" + isOpen +",");
		//未开启时，到开启剩余的秒数，已开启时，此参数为0
		buf.append("waitSeconds:" + waitSeconds +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}