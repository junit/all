package com.mokylin.game.robot.logic.destiny.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.destiny.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 宿命对决信息消息
 */
public class ResDestinyInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResDestinyInfoMessage.class);
	
	//下次刷新时间
	private Integer nextRefreshTime;
	//对手信息
	private List<DestinyInfo> infos = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//下次刷新时间
			writeInt(buf, this.nextRefreshTime);
			//对手信息
			writeShort(buf, (short)infos.size());
			for (int i = 0; i < infos.size(); i++) {
				writeBean(buf, infos.get(i));
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
			//下次刷新时间
			this.nextRefreshTime = readInt(buf);
			//对手信息
			int infos_length = readShort(buf);
			for (int i = 0; i < infos_length; i++) {
				infos.add((DestinyInfo)readBean(buf, DestinyInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 下次刷新时间
	 * @return 
	 */
	public Integer getNextRefreshTime(){
		return nextRefreshTime;
	}
	
	/**
	 * set 下次刷新时间
	 */
	public void setNextRefreshTime(Integer nextRefreshTime){
		this.nextRefreshTime = nextRefreshTime;
	}
	
	/**
	 * get 对手信息
	 * @return 
	 */
	public List<DestinyInfo> getInfos(){
		return infos;
	}
	
	/**
	 * set 对手信息
	 */
	public void setInfos(List<DestinyInfo> infos){
		this.infos = infos;
	}
	
	
	@Override
	public int getId() {
		return 107101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//下次刷新时间
		buf.append("nextRefreshTime:" + nextRefreshTime +",");
		//对手信息
		buf.append("infos:{");
		for (int i = 0; i < infos.size(); i++) {
			buf.append(infos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}