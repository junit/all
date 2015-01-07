package com.mokylin.game.server.logic.skill.bean;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 援护技能信息
 */
public class AssistSkillInfo extends Bean {

	private static Logger log = Logger.getLogger(AssistSkillInfo.class);
	
	//对应AssistSkillConfig表中的id
	private List<Integer> id = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//对应AssistSkillConfig表中的id
			writeShort(buf, (short)id.size());
			for (int i = 0; i < id.size(); i++) {
				writeInt(buf, id.get(i));
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
			//对应AssistSkillConfig表中的id
			int id_length = readShort(buf);
			for (int i = 0; i < id_length; i++) {
				id.add(readInt(buf));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 对应AssistSkillConfig表中的id
	 * @return 
	 */
	public List<Integer> getId(){
		return id;
	}
	
	/**
	 * set 对应AssistSkillConfig表中的id
	 */
	public void setId(List<Integer> id){
		this.id = id;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//对应AssistSkillConfig表中的id
		buf.append("id:{");
		for (int i = 0; i < id.size(); i++) {
			buf.append(id.get(i) +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}