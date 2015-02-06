package com.mokylin.game.server.logic.account.message;


import com.mokylin.game.core.message.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 登录失败消息
 */
public class ResAccountLoginFailedMessage extends Message{

	private static Logger log = Logger.getLogger(ResAccountLoginFailedMessage.class);
	
	//错误代码
	private Byte err;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//错误代码
			writeByte(buf, this.err);
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
			//错误代码
			this.err = readByte(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 错误代码
	 * @return 
	 */
	public Byte getErr(){
		return err;
	}
	
	/**
	 * set 错误代码
	 */
	public void setErr(Byte err){
		this.err = err;
	}
	
	
	@Override
	public int getId() {
		return 100201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//错误代码
		buf.append("err:" + err +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}