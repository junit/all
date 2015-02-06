package com.mokylin.game.server.logic.role.message;


import com.mokylin.game.core.message.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 创建角色返回消息
 */
public class ResRoleCreateMessage extends Message{

	private static Logger log = Logger.getLogger(ResRoleCreateMessage.class);
	
	//角色
	private RoleInfo role;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色
			writeBean(buf, this.role);
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
			//角色
			this.role = (RoleInfo)readBean(buf, RoleInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色
	 * @return 
	 */
	public RoleInfo getRole(){
		return role;
	}
	
	/**
	 * set 角色
	 */
	public void setRole(RoleInfo role){
		this.role = role;
	}
	
	
	@Override
	public int getId() {
		return 101202;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色
		if(this.role!=null) buf.append("role:" + role.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}