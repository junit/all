package com.mokylin.game.robot.logic.level.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 前端请求完成关卡消息
 */
public class ReqCompleteLevelMessage extends Message{

	private static Logger log = Logger.getLogger(ReqCompleteLevelMessage.class);
	
	//角色id
	private Integer roleId;
	//关卡难度id
	private Integer levelDifficultyId;
	//通关时长（秒）
	private Integer duration;
	//是否成功（0：挑战失败，1：挑战成功）
	private Integer success;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.roleId);
			//关卡难度id
			writeInt(buf, this.levelDifficultyId);
			//通关时长（秒）
			writeInt(buf, this.duration);
			//是否成功（0：挑战失败，1：挑战成功）
			writeInt(buf, this.success);
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
			this.roleId = readInt(buf);
			//关卡难度id
			this.levelDifficultyId = readInt(buf);
			//通关时长（秒）
			this.duration = readInt(buf);
			//是否成功（0：挑战失败，1：挑战成功）
			this.success = readInt(buf);
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
	public Integer getRoleId(){
		return roleId;
	}
	
	/**
	 * set 角色id
	 */
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	
	/**
	 * get 关卡难度id
	 * @return 
	 */
	public Integer getLevelDifficultyId(){
		return levelDifficultyId;
	}
	
	/**
	 * set 关卡难度id
	 */
	public void setLevelDifficultyId(Integer levelDifficultyId){
		this.levelDifficultyId = levelDifficultyId;
	}
	
	/**
	 * get 通关时长（秒）
	 * @return 
	 */
	public Integer getDuration(){
		return duration;
	}
	
	/**
	 * set 通关时长（秒）
	 */
	public void setDuration(Integer duration){
		this.duration = duration;
	}
	
	/**
	 * get 是否成功（0：挑战失败，1：挑战成功）
	 * @return 
	 */
	public Integer getSuccess(){
		return success;
	}
	
	/**
	 * set 是否成功（0：挑战失败，1：挑战成功）
	 */
	public void setSuccess(Integer success){
		this.success = success;
	}
	
	
	@Override
	public int getId() {
		return 102202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("roleId:" + roleId +",");
		//关卡难度id
		buf.append("levelDifficultyId:" + levelDifficultyId +",");
		//通关时长（秒）
		buf.append("duration:" + duration +",");
		//是否成功（0：挑战失败，1：挑战成功）
		buf.append("success:" + success +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}