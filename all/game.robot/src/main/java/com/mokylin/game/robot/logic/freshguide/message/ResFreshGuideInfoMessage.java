package com.mokylin.game.robot.logic.freshguide.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 新手指导信息消息
 */
public class ResFreshGuideInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResFreshGuideInfoMessage.class);
	
	//新手指导信息
	private List<Integer> completedIds = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//新手指导信息
			writeShort(buf, (short)completedIds.size());
			for (int i = 0; i < completedIds.size(); i++) {
				writeInt(buf, completedIds.get(i));
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
			//新手指导信息
			int completedIds_length = readShort(buf);
			for (int i = 0; i < completedIds_length; i++) {
				completedIds.add(readInt(buf));
			}
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
	public List<Integer> getCompletedIds(){
		return completedIds;
	}
	
	/**
	 * set 新手指导信息
	 */
	public void setCompletedIds(List<Integer> completedIds){
		this.completedIds = completedIds;
	}
	
	
	@Override
	public int getId() {
		return 213101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//新手指导信息
		buf.append("completedIds:{");
		for (int i = 0; i < completedIds.size(); i++) {
			buf.append(completedIds.get(i) +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}