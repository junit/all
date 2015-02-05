package com.mokylin.game.robot.logic.login.message;


import com.mokylin.game.core.message.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 登录消息
 */
public class ReqLoginMessage extends Message{

	private static Logger log = Logger.getLogger(ReqLoginMessage.class);
	
	//帐号名称
	private String accountName;
	//平台
	private Integer platform;
	//服务器
	private Integer server;
	//验证key/密码
	private String check;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//帐号名称
			writeString(buf, this.accountName);
			//平台
			writeInt(buf, this.platform);
			//服务器
			writeInt(buf, this.server);
			//验证key/密码
			writeString(buf, this.check);
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
			//帐号名称
			this.accountName = readString(buf);
			//平台
			this.platform = readInt(buf);
			//服务器
			this.server = readInt(buf);
			//验证key/密码
			this.check = readString(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 帐号名称
	 * @return 
	 */
	public String getAccountName(){
		return accountName;
	}
	
	/**
	 * set 帐号名称
	 */
	public void setAccountName(String accountName){
		this.accountName = accountName;
	}
	
	/**
	 * get 平台
	 * @return 
	 */
	public Integer getPlatform(){
		return platform;
	}
	
	/**
	 * set 平台
	 */
	public void setPlatform(Integer platform){
		this.platform = platform;
	}
	
	/**
	 * get 服务器
	 * @return 
	 */
	public Integer getServer(){
		return server;
	}
	
	/**
	 * set 服务器
	 */
	public void setServer(Integer server){
		this.server = server;
	}
	
	/**
	 * get 验证key/密码
	 * @return 
	 */
	public String getCheck(){
		return check;
	}
	
	/**
	 * set 验证key/密码
	 */
	public void setCheck(String check){
		this.check = check;
	}
	
	
	@Override
	public int getId() {
		return 100101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//帐号名称
		if(this.accountName!=null) buf.append("accountName:" + accountName.toString() +",");
		//平台
		buf.append("platform:" + platform +",");
		//服务器
		buf.append("server:" + server +",");
		//验证key/密码
		if(this.check!=null) buf.append("check:" + check.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}