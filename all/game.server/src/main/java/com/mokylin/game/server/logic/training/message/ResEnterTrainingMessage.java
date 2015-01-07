package com.mokylin.game.server.logic.training.message;


import com.mokylin.game.server.logic.training.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回请求进入训练项目结果消息
 */
public class ResEnterTrainingMessage extends Message{

	private static Logger log = Logger.getLogger(ResEnterTrainingMessage.class);
	
	//进入训练项目结果消息Id(0：成功,非0：失败的消息Id)
	private Integer msg;
	//单个项目训练结果信息
	private TrainingInfo trainingInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//进入训练项目结果消息Id(0：成功,非0：失败的消息Id)
			writeInt(buf, this.msg);
			//单个项目训练结果信息
			writeBean(buf, this.trainingInfo);
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
			//进入训练项目结果消息Id(0：成功,非0：失败的消息Id)
			this.msg = readInt(buf);
			//单个项目训练结果信息
			this.trainingInfo = (TrainingInfo)readBean(buf, TrainingInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 进入训练项目结果消息Id(0：成功,非0：失败的消息Id)
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 进入训练项目结果消息Id(0：成功,非0：失败的消息Id)
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
	}
	
	/**
	 * get 单个项目训练结果信息
	 * @return 
	 */
	public TrainingInfo getTrainingInfo(){
		return trainingInfo;
	}
	
	/**
	 * set 单个项目训练结果信息
	 */
	public void setTrainingInfo(TrainingInfo trainingInfo){
		this.trainingInfo = trainingInfo;
	}
	
	
	@Override
	public int getId() {
		return 301101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//进入训练项目结果消息Id(0：成功,非0：失败的消息Id)
		buf.append("msg:" + msg +",");
		//单个项目训练结果信息
		if(this.trainingInfo!=null) buf.append("trainingInfo:" + trainingInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}