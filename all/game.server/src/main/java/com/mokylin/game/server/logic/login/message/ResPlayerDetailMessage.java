package com.mokylin.game.server.logic.login.message;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.bean.Message;
import com.mokylin.game.server.logic.achievement.bean.AchievementInfo;
import com.mokylin.game.server.logic.buff.bean.BuffInfo;
import com.mokylin.game.server.logic.butterfly.bean.ButterflyInfo;
import com.mokylin.game.server.logic.discovery.bean.DiscoveryResultInfo;
import com.mokylin.game.server.logic.item.bean.ItemInfo;
import com.mokylin.game.server.logic.level.bean.ClearanceInfo;
import com.mokylin.game.server.logic.login.bean.CharacterInfos;
import com.mokylin.game.server.logic.login.bean.PlayerBaseInfo;
import com.mokylin.game.server.logic.login.bean.PlayerOtherInfo;
import com.mokylin.game.server.logic.lottery.bean.LotteryInfo;
import com.mokylin.game.server.logic.millionluck.bean.LuckRecordInfo;
import com.mokylin.game.server.logic.signin.bean.SigninInfo;
import com.mokylin.game.server.logic.skill.bean.AssistSkillInfo;
import com.mokylin.game.server.logic.soultrial.bean.SoulTrialHp;
import com.mokylin.game.server.logic.soultrial.bean.SoulTrialInfo;
import com.mokylin.game.server.logic.training.bean.TrainingInfo;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 玩家详细信息消息
 */
public class ResPlayerDetailMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerDetailMessage.class);
	
	//玩家基本信息
	private PlayerBaseInfo baseInfo;
	//玩家拥有的角色列表
	private List<CharacterInfos> characterInfos = new ArrayList<>();
	//玩家拥有的道具列表
	private List<ItemInfo> itemInfo = new ArrayList<>();
	//通关信息列表
	private List<ClearanceInfo> levelInfo = new ArrayList<>();
	//项目训练结果列表
	private List<TrainingInfo> trainingInfo = new ArrayList<>();
	//招财记录信息列表
	private List<LuckRecordInfo> luckRecordInfos = new ArrayList<>();
	//buff信息
	private List<BuffInfo> buffInfo = new ArrayList<>();
	//灵魂试炼角色剩余血量
	private List<SoulTrialHp> soulTrialHp = new ArrayList<>();
	//灵魂试炼信息
	private SoulTrialInfo soulTrialInfo;
	//当前探索结果信息
	private DiscoveryResultInfo discoveryResInfo;
	//已获得的成就
	private List<AchievementInfo> achievementInfo = new ArrayList<>();
	//签到信息
	private SigninInfo signinInfo;
	//地狱蝶信息
	private ButterflyInfo butterflyInfo;
	//抽奖信息
	private LotteryInfo lotteryInfo;
	//其他信息
	private PlayerOtherInfo otherInfo;
	//援护技能信息
	private AssistSkillInfo assistSkillInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//玩家基本信息
			writeBean(buf, this.baseInfo);
			//玩家拥有的角色列表
			writeShort(buf, (short)characterInfos.size());
			for (int i = 0; i < characterInfos.size(); i++) {
				writeBean(buf, characterInfos.get(i));
			}
			//玩家拥有的道具列表
			writeShort(buf, (short)itemInfo.size());
			for (int i = 0; i < itemInfo.size(); i++) {
				writeBean(buf, itemInfo.get(i));
			}
			//通关信息列表
			writeShort(buf, (short)levelInfo.size());
			for (int i = 0; i < levelInfo.size(); i++) {
				writeBean(buf, levelInfo.get(i));
			}
			//项目训练结果列表
			writeShort(buf, (short)trainingInfo.size());
			for (int i = 0; i < trainingInfo.size(); i++) {
				writeBean(buf, trainingInfo.get(i));
			}
			//招财记录信息列表
			writeShort(buf, (short)luckRecordInfos.size());
			for (int i = 0; i < luckRecordInfos.size(); i++) {
				writeBean(buf, luckRecordInfos.get(i));
			}
			//buff信息
			writeShort(buf, (short)buffInfo.size());
			for (int i = 0; i < buffInfo.size(); i++) {
				writeBean(buf, buffInfo.get(i));
			}
			//灵魂试炼角色剩余血量
			writeShort(buf, (short)soulTrialHp.size());
			for (int i = 0; i < soulTrialHp.size(); i++) {
				writeBean(buf, soulTrialHp.get(i));
			}
			//灵魂试炼信息
			writeBean(buf, this.soulTrialInfo);
			//当前探索结果信息
			writeBean(buf, this.discoveryResInfo);
			//已获得的成就
			writeShort(buf, (short)achievementInfo.size());
			for (int i = 0; i < achievementInfo.size(); i++) {
				writeBean(buf, achievementInfo.get(i));
			}
			//签到信息
			writeBean(buf, this.signinInfo);
			//地狱蝶信息
			writeBean(buf, this.butterflyInfo);
			//抽奖信息
			writeBean(buf, this.lotteryInfo);
			//其他信息
			writeBean(buf, this.otherInfo);
			//援护技能信息
			writeBean(buf, this.assistSkillInfo);
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
			//玩家基本信息
			this.baseInfo = (PlayerBaseInfo)readBean(buf, PlayerBaseInfo.class);
			//玩家拥有的角色列表
			int characterInfos_length = readShort(buf);
			for (int i = 0; i < characterInfos_length; i++) {
				characterInfos.add((CharacterInfos)readBean(buf, CharacterInfos.class));
			}
			//玩家拥有的道具列表
			int itemInfo_length = readShort(buf);
			for (int i = 0; i < itemInfo_length; i++) {
				itemInfo.add((ItemInfo)readBean(buf, ItemInfo.class));
			}
			//通关信息列表
			int levelInfo_length = readShort(buf);
			for (int i = 0; i < levelInfo_length; i++) {
				levelInfo.add((ClearanceInfo)readBean(buf, ClearanceInfo.class));
			}
			//项目训练结果列表
			int trainingInfo_length = readShort(buf);
			for (int i = 0; i < trainingInfo_length; i++) {
				trainingInfo.add((TrainingInfo)readBean(buf, TrainingInfo.class));
			}
			//招财记录信息列表
			int luckRecordInfos_length = readShort(buf);
			for (int i = 0; i < luckRecordInfos_length; i++) {
				luckRecordInfos.add((LuckRecordInfo)readBean(buf, LuckRecordInfo.class));
			}
			//buff信息
			int buffInfo_length = readShort(buf);
			for (int i = 0; i < buffInfo_length; i++) {
				buffInfo.add((BuffInfo)readBean(buf, BuffInfo.class));
			}
			//灵魂试炼角色剩余血量
			int soulTrialHp_length = readShort(buf);
			for (int i = 0; i < soulTrialHp_length; i++) {
				soulTrialHp.add((SoulTrialHp)readBean(buf, SoulTrialHp.class));
			}
			//灵魂试炼信息
			this.soulTrialInfo = (SoulTrialInfo)readBean(buf, SoulTrialInfo.class);
			//当前探索结果信息
			this.discoveryResInfo = (DiscoveryResultInfo)readBean(buf, DiscoveryResultInfo.class);
			//已获得的成就
			int achievementInfo_length = readShort(buf);
			for (int i = 0; i < achievementInfo_length; i++) {
				achievementInfo.add((AchievementInfo)readBean(buf, AchievementInfo.class));
			}
			//签到信息
			this.signinInfo = (SigninInfo)readBean(buf, SigninInfo.class);
			//地狱蝶信息
			this.butterflyInfo = (ButterflyInfo)readBean(buf, ButterflyInfo.class);
			//抽奖信息
			this.lotteryInfo = (LotteryInfo)readBean(buf, LotteryInfo.class);
			//其他信息
			this.otherInfo = (PlayerOtherInfo)readBean(buf, PlayerOtherInfo.class);
			//援护技能信息
			this.assistSkillInfo = (AssistSkillInfo)readBean(buf, AssistSkillInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 玩家基本信息
	 * @return 
	 */
	public PlayerBaseInfo getBaseInfo(){
		return baseInfo;
	}
	
	/**
	 * set 玩家基本信息
	 */
	public void setBaseInfo(PlayerBaseInfo baseInfo){
		this.baseInfo = baseInfo;
	}
	
	/**
	 * get 玩家拥有的角色列表
	 * @return 
	 */
	public List<CharacterInfos> getCharacterInfos(){
		return characterInfos;
	}
	
	/**
	 * set 玩家拥有的角色列表
	 */
	public void setCharacterInfos(List<CharacterInfos> characterInfos){
		this.characterInfos = characterInfos;
	}
	
	/**
	 * get 玩家拥有的道具列表
	 * @return 
	 */
	public List<ItemInfo> getItemInfo(){
		return itemInfo;
	}
	
	/**
	 * set 玩家拥有的道具列表
	 */
	public void setItemInfo(List<ItemInfo> itemInfo){
		this.itemInfo = itemInfo;
	}
	
	/**
	 * get 通关信息列表
	 * @return 
	 */
	public List<ClearanceInfo> getLevelInfo(){
		return levelInfo;
	}
	
	/**
	 * set 通关信息列表
	 */
	public void setLevelInfo(List<ClearanceInfo> levelInfo){
		this.levelInfo = levelInfo;
	}
	
	/**
	 * get 项目训练结果列表
	 * @return 
	 */
	public List<TrainingInfo> getTrainingInfo(){
		return trainingInfo;
	}
	
	/**
	 * set 项目训练结果列表
	 */
	public void setTrainingInfo(List<TrainingInfo> trainingInfo){
		this.trainingInfo = trainingInfo;
	}
	
	/**
	 * get 招财记录信息列表
	 * @return 
	 */
	public List<LuckRecordInfo> getLuckRecordInfos(){
		return luckRecordInfos;
	}
	
	/**
	 * set 招财记录信息列表
	 */
	public void setLuckRecordInfos(List<LuckRecordInfo> luckRecordInfos){
		this.luckRecordInfos = luckRecordInfos;
	}
	
	/**
	 * get buff信息
	 * @return 
	 */
	public List<BuffInfo> getBuffInfo(){
		return buffInfo;
	}
	
	/**
	 * set buff信息
	 */
	public void setBuffInfo(List<BuffInfo> buffInfo){
		this.buffInfo = buffInfo;
	}
	
	/**
	 * get 灵魂试炼角色剩余血量
	 * @return 
	 */
	public List<SoulTrialHp> getSoulTrialHp(){
		return soulTrialHp;
	}
	
	/**
	 * set 灵魂试炼角色剩余血量
	 */
	public void setSoulTrialHp(List<SoulTrialHp> soulTrialHp){
		this.soulTrialHp = soulTrialHp;
	}
	
	/**
	 * get 灵魂试炼信息
	 * @return 
	 */
	public SoulTrialInfo getSoulTrialInfo(){
		return soulTrialInfo;
	}
	
	/**
	 * set 灵魂试炼信息
	 */
	public void setSoulTrialInfo(SoulTrialInfo soulTrialInfo){
		this.soulTrialInfo = soulTrialInfo;
	}
	
	/**
	 * get 当前探索结果信息
	 * @return 
	 */
	public DiscoveryResultInfo getDiscoveryResInfo(){
		return discoveryResInfo;
	}
	
	/**
	 * set 当前探索结果信息
	 */
	public void setDiscoveryResInfo(DiscoveryResultInfo discoveryResInfo){
		this.discoveryResInfo = discoveryResInfo;
	}
	
	/**
	 * get 已获得的成就
	 * @return 
	 */
	public List<AchievementInfo> getAchievementInfo(){
		return achievementInfo;
	}
	
	/**
	 * set 已获得的成就
	 */
	public void setAchievementInfo(List<AchievementInfo> achievementInfo){
		this.achievementInfo = achievementInfo;
	}
	
	/**
	 * get 签到信息
	 * @return 
	 */
	public SigninInfo getSigninInfo(){
		return signinInfo;
	}
	
	/**
	 * set 签到信息
	 */
	public void setSigninInfo(SigninInfo signinInfo){
		this.signinInfo = signinInfo;
	}
	
	/**
	 * get 地狱蝶信息
	 * @return 
	 */
	public ButterflyInfo getButterflyInfo(){
		return butterflyInfo;
	}
	
	/**
	 * set 地狱蝶信息
	 */
	public void setButterflyInfo(ButterflyInfo butterflyInfo){
		this.butterflyInfo = butterflyInfo;
	}
	
	/**
	 * get 抽奖信息
	 * @return 
	 */
	public LotteryInfo getLotteryInfo(){
		return lotteryInfo;
	}
	
	/**
	 * set 抽奖信息
	 */
	public void setLotteryInfo(LotteryInfo lotteryInfo){
		this.lotteryInfo = lotteryInfo;
	}
	
	/**
	 * get 其他信息
	 * @return 
	 */
	public PlayerOtherInfo getOtherInfo(){
		return otherInfo;
	}
	
	/**
	 * set 其他信息
	 */
	public void setOtherInfo(PlayerOtherInfo otherInfo){
		this.otherInfo = otherInfo;
	}
	
	/**
	 * get 援护技能信息
	 * @return 
	 */
	public AssistSkillInfo getAssistSkillInfo(){
		return assistSkillInfo;
	}
	
	/**
	 * set 援护技能信息
	 */
	public void setAssistSkillInfo(AssistSkillInfo assistSkillInfo){
		this.assistSkillInfo = assistSkillInfo;
	}
	
	
	@Override
	public int getId() {
		return 100104;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//玩家基本信息
		if(this.baseInfo!=null) buf.append("baseInfo:" + baseInfo.toString() +",");
		//玩家拥有的角色列表
		buf.append("characterInfos:{");
		for (int i = 0; i < characterInfos.size(); i++) {
			buf.append(characterInfos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//玩家拥有的道具列表
		buf.append("itemInfo:{");
		for (int i = 0; i < itemInfo.size(); i++) {
			buf.append(itemInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//通关信息列表
		buf.append("levelInfo:{");
		for (int i = 0; i < levelInfo.size(); i++) {
			buf.append(levelInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//项目训练结果列表
		buf.append("trainingInfo:{");
		for (int i = 0; i < trainingInfo.size(); i++) {
			buf.append(trainingInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//招财记录信息列表
		buf.append("luckRecordInfos:{");
		for (int i = 0; i < luckRecordInfos.size(); i++) {
			buf.append(luckRecordInfos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//buff信息
		buf.append("buffInfo:{");
		for (int i = 0; i < buffInfo.size(); i++) {
			buf.append(buffInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//灵魂试炼角色剩余血量
		buf.append("soulTrialHp:{");
		for (int i = 0; i < soulTrialHp.size(); i++) {
			buf.append(soulTrialHp.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//灵魂试炼信息
		if(this.soulTrialInfo!=null) buf.append("soulTrialInfo:" + soulTrialInfo.toString() +",");
		//当前探索结果信息
		if(this.discoveryResInfo!=null) buf.append("discoveryResInfo:" + discoveryResInfo.toString() +",");
		//已获得的成就
		buf.append("achievementInfo:{");
		for (int i = 0; i < achievementInfo.size(); i++) {
			buf.append(achievementInfo.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//签到信息
		if(this.signinInfo!=null) buf.append("signinInfo:" + signinInfo.toString() +",");
		//地狱蝶信息
		if(this.butterflyInfo!=null) buf.append("butterflyInfo:" + butterflyInfo.toString() +",");
		//抽奖信息
		if(this.lotteryInfo!=null) buf.append("lotteryInfo:" + lotteryInfo.toString() +",");
		//其他信息
		if(this.otherInfo!=null) buf.append("otherInfo:" + otherInfo.toString() +",");
		//援护技能信息
		if(this.assistSkillInfo!=null) buf.append("assistSkillInfo:" + assistSkillInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}