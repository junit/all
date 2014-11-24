package com.mokylin.game.robot.logic.role.message;


import com.mokylin.game.core.message.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 创建角色消息
 */
public class ReqRoleCreateMessage extends Message{

	private static Logger log = Logger.getLogger(ReqRoleCreateMessage.class);
	
	//角色名
	private String name;
	//性别
	private Byte sex;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色名
			writeString(buf, this.name);
			//性别
			writeByte(buf, this.sex);
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
			//角色名
			this.name = readString(buf);
			//性别
			this.sex = readByte(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色名
	 * @return 
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * set 角色名
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * get 性别
	 * @return 
	 */
	public Byte getSex(){
		return sex;
	}
	
	/**
	 * set 性别
	 */
	public void setSex(Byte sex){
		this.sex = sex;
	}
	
	
	@Override
	public int getId() {
		return 101101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色名
		if(this.name!=null) buf.append("name:" + name.toString() +",");
		//性别
		buf.append("sex:" + sex +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}