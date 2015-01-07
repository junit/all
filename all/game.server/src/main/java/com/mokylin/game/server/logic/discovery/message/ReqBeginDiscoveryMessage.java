package com.mokylin.game.server.logic.discovery.message;

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
 * 前端请求开始探索消息
 */
public class ReqBeginDiscoveryMessage extends Message{

	private static Logger log = Logger.getLogger(ReqBeginDiscoveryMessage.class);
	
	//探索角色id
	private List<Integer> roles = new ArrayList<>();
	//探索id
	private Integer discoveryId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//探索角色id
			writeShort(buf, (short)roles.size());
			for (int i = 0; i < roles.size(); i++) {
				writeInt(buf, roles.get(i));
			}
			//探索id
			writeInt(buf, this.discoveryId);
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
			//探索角色id
			int roles_length = readShort(buf);
			for (int i = 0; i < roles_length; i++) {
				roles.add(readInt(buf));
			}
			//探索id
			this.discoveryId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 探索角色id
	 * @return 
	 */
	public List<Integer> getRoles(){
		return roles;
	}
	
	/**
	 * set 探索角色id
	 */
	public void setRoles(List<Integer> roles){
		this.roles = roles;
	}
	
	/**
	 * get 探索id
	 * @return 
	 */
	public Integer getDiscoveryId(){
		return discoveryId;
	}
	
	/**
	 * set 探索id
	 */
	public void setDiscoveryId(Integer discoveryId){
		this.discoveryId = discoveryId;
	}
	
	
	@Override
	public int getId() {
		return 303201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//探索角色id
		buf.append("roles:{");
		for (int i = 0; i < roles.size(); i++) {
			buf.append(roles.get(i) +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//探索id
		buf.append("discoveryId:" + discoveryId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}