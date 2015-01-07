package com.mokylin.game.server.logic.butterfly.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 开始地狱蝶回复消息
 */
public class ResStartButterflyMessage extends Message{

	private static Logger log = Logger.getLogger(ResStartButterflyMessage.class);
	
	//0：成功，1：cd中，2：对手不能被抢，3：自己已毕业，不能再抢
	private Integer result;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0：成功，1：cd中，2：对手不能被抢，3：自己已毕业，不能再抢
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
			//0：成功，1：cd中，2：对手不能被抢，3：自己已毕业，不能再抢
			this.result = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0：成功，1：cd中，2：对手不能被抢，3：自己已毕业，不能再抢
	 * @return 
	 */
	public Integer getResult(){
		return result;
	}
	
	/**
	 * set 0：成功，1：cd中，2：对手不能被抢，3：自己已毕业，不能再抢
	 */
	public void setResult(Integer result){
		this.result = result;
	}
	
	
	@Override
	public int getId() {
		return 211202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0：成功，1：cd中，2：对手不能被抢，3：自己已毕业，不能再抢
		buf.append("result:" + result +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}