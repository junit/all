package com.mokylin.game.robot.logic.destiny.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 开始对决消息
 */
public class ReqDestinyFightMessage extends Message{

	private static Logger log = Logger.getLogger(ReqDestinyFightMessage.class);
	
	//对决表索引id
	private Integer index;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//对决表索引id
			writeInt(buf, this.index);
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
			//对决表索引id
			this.index = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 对决表索引id
	 * @return 
	 */
	public Integer getIndex(){
		return index;
	}
	
	/**
	 * set 对决表索引id
	 */
	public void setIndex(Integer index){
		this.index = index;
	}
	
	
	@Override
	public int getId() {
		return 107202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//对决表索引id
		buf.append("index:" + index +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}