package com.mokylin.game.server.logic.role.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.core.message.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 角色信息消息
 */
public class ResRoleInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResRoleInfoMessage.class);
	
	//角色列表
	private List<RoleInfo> roles = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色列表
			writeShort(buf, (short)roles.size());
			for (int i = 0; i < roles.size(); i++) {
				writeBean(buf, roles.get(i));
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
			//角色列表
			int roles_length = readShort(buf);
			for (int i = 0; i < roles_length; i++) {
				roles.add((RoleInfo)readBean(buf, RoleInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色列表
	 * @return 
	 */
	public List<RoleInfo> getRoles(){
		return roles;
	}
	
	/**
	 * set 角色列表
	 */
	public void setRoles(List<RoleInfo> roles){
		this.roles = roles;
	}
	
	
	@Override
	public int getId() {
		return 101201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色列表
		buf.append("roles:{");
		for (int i = 0; i < roles.size(); i++) {
			buf.append(roles.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}