package com.mokylin.game.server.logic.fighting.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 结束战斗请求消息
 */
public class ReqEndFightingMessage extends Message{

	private static Logger log = Logger.getLogger(ReqEndFightingMessage.class);
	
	//0：负 1：胜
	private Integer success;
	//战斗验证数据
	private byte[] fightData;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0：负 1：胜
			writeInt(buf, this.success);
			//战斗验证数据
			writeBytes(buf, this.fightData);
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
			//0：负 1：胜
			this.success = readInt(buf);
			//战斗验证数据
			this.fightData = readBytes(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0：负 1：胜
	 * @return 
	 */
	public Integer getSuccess(){
		return success;
	}
	
	/**
	 * set 0：负 1：胜
	 */
	public void setSuccess(Integer success){
		this.success = success;
	}
	
	/**
	 * get 战斗验证数据
	 * @return 
	 */
	public byte[] getFightData(){
		return fightData;
	}
	
	/**
	 * set 战斗验证数据
	 */
	public void setFightData(byte[] fightData){
		this.fightData = fightData;
	}
	
	
	@Override
	public int getId() {
		return 400102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0：负 1：胜
		buf.append("success:" + success +",");
		//战斗验证数据
		if(this.fightData!=null) buf.append("fightData:" + fightData.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}