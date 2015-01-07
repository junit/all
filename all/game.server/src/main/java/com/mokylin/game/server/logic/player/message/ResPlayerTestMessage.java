package com.mokylin.game.server.logic.player.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 测试消息
 */
public class ResPlayerTestMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerTestMessage.class);
	
	//标识
	private Long flag;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//标识
			writeLong(buf, this.flag);
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
			//标识
			this.flag = readLong(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 标识
	 * @return 
	 */
	public Long getFlag(){
		return flag;
	}
	
	/**
	 * set 标识
	 */
	public void setFlag(Long flag){
		this.flag = flag;
	}
	
	
	@Override
	public int getId() {
		return 105108;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//标识
		buf.append("flag:" + flag +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}