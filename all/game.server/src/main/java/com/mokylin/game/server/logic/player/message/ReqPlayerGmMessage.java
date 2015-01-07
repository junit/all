package com.mokylin.game.server.logic.player.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 输入GM指令消息
 */
public class ReqPlayerGmMessage extends Message{

	private static Logger log = Logger.getLogger(ReqPlayerGmMessage.class);
	
	//GM指令
	private String command;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//GM指令
			writeString(buf, this.command);
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
			//GM指令
			this.command = readString(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get GM指令
	 * @return 
	 */
	public String getCommand(){
		return command;
	}
	
	/**
	 * set GM指令
	 */
	public void setCommand(String command){
		this.command = command;
	}
	
	
	@Override
	public int getId() {
		return 105104;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//GM指令
		if(this.command!=null) buf.append("command:" + command.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}