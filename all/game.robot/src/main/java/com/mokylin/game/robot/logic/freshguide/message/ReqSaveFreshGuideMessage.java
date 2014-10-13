package com.mokylin.game.robot.logic.freshguide.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 请求保存新手指导信息消息
 */
public class ReqSaveFreshGuideMessage extends Message{

	private static Logger log = Logger.getLogger(ReqSaveFreshGuideMessage.class);
	
	//新手指导信息
	private Integer completedId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//新手指导信息
			writeInt(buf, this.completedId);
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
			//新手指导信息
			this.completedId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 新手指导信息
	 * @return 
	 */
	public Integer getCompletedId(){
		return completedId;
	}
	
	/**
	 * set 新手指导信息
	 */
	public void setCompletedId(Integer completedId){
		this.completedId = completedId;
	}
	
	
	@Override
	public int getId() {
		return 213202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//新手指导信息
		buf.append("completedId:" + completedId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}