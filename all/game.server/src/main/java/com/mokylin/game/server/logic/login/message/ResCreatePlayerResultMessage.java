package com.mokylin.game.server.logic.login.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 创建玩家失败消息
 */
public class ResCreatePlayerResultMessage extends Message{

	private static Logger log = Logger.getLogger(ResCreatePlayerResultMessage.class);
	
	//0-成功  1-已有该玩家名
	private Byte errId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0-成功  1-已有该玩家名
			writeByte(buf, this.errId);
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
			//0-成功  1-已有该玩家名
			this.errId = readByte(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0-成功  1-已有该玩家名
	 * @return 
	 */
	public Byte getErrId(){
		return errId;
	}
	
	/**
	 * set 0-成功  1-已有该玩家名
	 */
	public void setErrId(Byte errId){
		this.errId = errId;
	}
	
	
	@Override
	public int getId() {
		return 100103;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0-成功  1-已有该玩家名
		buf.append("errId:" + errId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}