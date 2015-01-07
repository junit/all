package com.mokylin.game.server.logic.food.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 制作食物返回消息
 */
public class ResFoodCookMessage extends Message{

	private static Logger log = Logger.getLogger(ResFoodCookMessage.class);
	
	//0:失败 食物id:成功
	private Integer ret;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//0:失败 食物id:成功
			writeInt(buf, this.ret);
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
			//0:失败 食物id:成功
			this.ret = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 0:失败 食物id:成功
	 * @return 
	 */
	public Integer getRet(){
		return ret;
	}
	
	/**
	 * set 0:失败 食物id:成功
	 */
	public void setRet(Integer ret){
		this.ret = ret;
	}
	
	
	@Override
	public int getId() {
		return 106101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//0:失败 食物id:成功
		buf.append("ret:" + ret +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}