package com.mokylin.game.server.logic.login.bean;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.bean.Bean;
import com.mokylin.game.server.logic.equip.bean.EquipInfo;
import com.mokylin.game.server.logic.skill.bean.SkillInfo;
import com.mokylin.game.server.logic.soulability.bean.SoulAbilityInfo;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 拥有的角色列表信息
 */
public class CharacterInfos extends Bean {

	private static Logger log = Logger.getLogger(CharacterInfos.class);
	
	//角色Id
	private Integer charId;
	
	//角色阶级
	private Integer stageLevel;
	
	//装备信息
	private List<EquipInfo> equipInfo = new ArrayList<>();
	//技能信息
	private List<SkillInfo> skillInfo = new ArrayList<>();
	//灵魂能力信息
	private List<SoulAbilityInfo> soulAbilityInfos = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色Id
			writeInt(buf, this.charId);
			//角色阶级
			writeInt(buf, this.stageLevel);
			//装备信息
			writeShort(buf, (short)equipInfo.size());
			for (int i = 0; i < equipInfo.size(); i++) {
				writeBean(buf, equipInfo.get(i));
			}
			//技能信息
			writeShort(buf, (short)skillInfo.size());
			for (int i = 0; i < skillInfo.size(); i++) {
				writeBean(buf, skillInfo.get(i));
			}
			//灵魂能力信息
			writeShort(buf, (short)soulAbilityInfos.size());
			for (int i = 0; i < soulAbilityInfos.size(); i++) {
				writeBean(buf, soulAbilityInfos.get(i));
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
			//角色Id
			this.charId = readInt(buf);
			//角色阶级
			this.stageLevel = readInt(buf);
			//装备信息
			int equipInfo_length = readShort(buf);
			for (int i = 0; i < equipInfo_length; i++) {
				equipInfo.add((EquipInfo)readBean(buf, EquipInfo.class));
			}
			//技能信息
			int skillInfo_length = readShort(buf);
			for (int i = 0; i < skillInfo_length; i++) {
				skillInfo.add((SkillInfo)readBean(buf, SkillInfo.class));
			}
			//灵魂能力信息
			int soulAbilityInfos_length = readShort(buf);
			for (int i = 0; i < soulAbilityInfos_length; i++) {
				soulAbilityInfos.add((SoulAbilityInfo)readBean(buf, SoulAbilityInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色Id
	 * @return 
	 */
	public Integer getCharId(){
		return charId;
	}
	
	/**
	 * set 角色Id
	 */
	public void setCharId(Integer charId){
		this.charId = charId;
	}
	
	/**
	 * get 角色阶级
	 * @return 
	 */
	public Integer getStageLevel(){
		return stageLevel;
	}
	
	/**
	 * set 角色阶级
	 */
	public void setStageLevel(Integer stageLevel){
		this.stageLevel = stageLevel;
	}
	
	/**
	 * get 装备信息
	 * @return 
	 */
	public List<EquipInfo> getEquipInfo(){
		return equipInfo;
	}
	
	/**
	 * set 装备信息
	 */
	public void setEquipInfo(List<EquipInfo> equipInfo){
		this.equipInfo = equipInfo;
	}
	
	/**
	 * get 技能信息
	 * @return 
	 */
	public List<SkillInfo> getSkillInfo(){
		return skillInfo;
	}
	
	/**
	 * set 技能信息
	 */
	public void setSkillInfo(List<SkillInfo> skillInfo){
		this.skillInfo = skillInfo;
	}
	
	/**
	 * get 灵魂能力信息
	 * @return 
	 */
	public List<SoulAbilityInfo> getSoulAbilityInfos(){
		return soulAbilityInfos;
	}
	
	/**
	 * set 灵魂能力信息
	 */
	public void setSoulAbilityInfos(List<SoulAbilityInfo> soulAbilityInfos){
		this.soulAbilityInfos = soulAbilityInfos;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色Id
		buf.append("charId:" + charId +",");
		//角色阶级
		buf.append("stageLevel:" + stageLevel +",");
		//装备信息
		buf.append("equipInfo:{");
		for (int i = 0; i < equipInfo.size(); i++) {
			buf.append(equipInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//技能信息
		buf.append("skillInfo:{");
		for (int i = 0; i < skillInfo.size(); i++) {
			buf.append(skillInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//灵魂能力信息
		buf.append("soulAbilityInfos:{");
		for (int i = 0; i < soulAbilityInfos.size(); i++) {
			buf.append(soulAbilityInfos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}