package com.mokylin.game.robot.logic.training.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 前端请求进入训练项目消息
 */
public class ReqEnterTrainingMessage extends Message{

	private static Logger log = Logger.getLogger(ReqEnterTrainingMessage.class);
	
	//训练id
	private Integer trainingId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//训练id
			writeInt(buf, this.trainingId);
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
			//训练id
			this.trainingId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 训练id
	 * @return 
	 */
	public Integer getTrainingId(){
		return trainingId;
	}
	
	/**
	 * set 训练id
	 */
	public void setTrainingId(Integer trainingId){
		this.trainingId = trainingId;
	}
	
	
	@Override
	public int getId() {
		return 301202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//训练id
		buf.append("trainingId:" + trainingId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}