package com.mokylin.game.server.logic.soultrial.message;


import com.mokylin.game.server.logic.soultrial.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 消息
 */
public class ResSoulTrialInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResSoulTrialInfoMessage.class);
	
	//灵魂试炼信息
	private SoulTrialInfo soulTrialInfo;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//灵魂试炼信息
			writeBean(buf, this.soulTrialInfo);
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
			//灵魂试炼信息
			this.soulTrialInfo = (SoulTrialInfo)readBean(buf, SoulTrialInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
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
	
	
	@Override
	public int getId() {
		return 204101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//灵魂试炼信息
		if(this.soulTrialInfo!=null) buf.append("soulTrialInfo:" + soulTrialInfo.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}