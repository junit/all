package com.mokylin.game.server.logic.skill.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.server.logic.skill.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 角色进阶时，更换技能id消息
 */
public class ResCharacterSkillsMessage extends Message{

	private static Logger log = Logger.getLogger(ResCharacterSkillsMessage.class);
	
	//角色id
	private Integer characterId;
	//角色进阶后拥有的技能id
	private List<SkillInfo> skillInfo = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.characterId);
			//角色进阶后拥有的技能id
			writeShort(buf, (short)skillInfo.size());
			for (int i = 0; i < skillInfo.size(); i++) {
				writeBean(buf, skillInfo.get(i));
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
			//角色id
			this.characterId = readInt(buf);
			//角色进阶后拥有的技能id
			int skillInfo_length = readShort(buf);
			for (int i = 0; i < skillInfo_length; i++) {
				skillInfo.add((SkillInfo)readBean(buf, SkillInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色id
	 * @return 
	 */
	public Integer getCharacterId(){
		return characterId;
	}
	
	/**
	 * set 角色id
	 */
	public void setCharacterId(Integer characterId){
		this.characterId = characterId;
	}
	
	/**
	 * get 角色进阶后拥有的技能id
	 * @return 
	 */
	public List<SkillInfo> getSkillInfo(){
		return skillInfo;
	}
	
	/**
	 * set 角色进阶后拥有的技能id
	 */
	public void setSkillInfo(List<SkillInfo> skillInfo){
		this.skillInfo = skillInfo;
	}
	
	
	@Override
	public int getId() {
		return 208101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("characterId:" + characterId +",");
		//角色进阶后拥有的技能id
		buf.append("skillInfo:{");
		for (int i = 0; i < skillInfo.size(); i++) {
			buf.append(skillInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}