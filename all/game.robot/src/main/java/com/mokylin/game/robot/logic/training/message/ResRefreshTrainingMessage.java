package com.mokylin.game.robot.logic.training.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.training.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回刷新训练项目结果消息
 */
public class ResRefreshTrainingMessage extends Message{

	private static Logger log = Logger.getLogger(ResRefreshTrainingMessage.class);
	
	//新训练项目结果消息Id(0：成功,非0：失败的消息Id)
	private Integer msg;
	//项目训练结果列表
	private List<TrainingInfo> trainingInfos = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//新训练项目结果消息Id(0：成功,非0：失败的消息Id)
			writeInt(buf, this.msg);
			//项目训练结果列表
			writeShort(buf, (short)trainingInfos.size());
			for (int i = 0; i < trainingInfos.size(); i++) {
				writeBean(buf, trainingInfos.get(i));
			}
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
			//新训练项目结果消息Id(0：成功,非0：失败的消息Id)
			this.msg = readInt(buf);
			//项目训练结果列表
			int trainingInfos_length = readShort(buf);
			for (int i = 0; i < trainingInfos_length; i++) {
				trainingInfos.add((TrainingInfo)readBean(buf, TrainingInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 新训练项目结果消息Id(0：成功,非0：失败的消息Id)
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 新训练项目结果消息Id(0：成功,非0：失败的消息Id)
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
	}
	
	/**
	 * get 项目训练结果列表
	 * @return 
	 */
	public List<TrainingInfo> getTrainingInfos(){
		return trainingInfos;
	}
	
	/**
	 * set 项目训练结果列表
	 */
	public void setTrainingInfos(List<TrainingInfo> trainingInfos){
		this.trainingInfos = trainingInfos;
	}
	
	
	@Override
	public int getId() {
		return 301102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//新训练项目结果消息Id(0：成功,非0：失败的消息Id)
		buf.append("msg:" + msg +",");
		//项目训练结果列表
		buf.append("trainingInfos:{");
		for (int i = 0; i < trainingInfos.size(); i++) {
			buf.append(trainingInfos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}