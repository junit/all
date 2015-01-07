package com.mokylin.game.server.logic.level.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 前端请求进入关卡消息
 */
public class ReqEnterLevelMessage extends Message{

	private static Logger log = Logger.getLogger(ReqEnterLevelMessage.class);
	
	//角色id
	private Integer roleId;
	//关卡难度id
	private Integer levelDifficultyId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色id
			writeInt(buf, this.roleId);
			//关卡难度id
			writeInt(buf, this.levelDifficultyId);
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
	
	
	@Override
	public int getId() {
		return 102201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色id
		buf.append("roleId:" + roleId +",");
		//关卡难度id
		buf.append("levelDifficultyId:" + levelDifficultyId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}