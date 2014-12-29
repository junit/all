package com.mokylin.game.robot.logic.girl.message;


import com.mokylin.game.robot.logic.girl.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 交往成功之后返回消息
 */
public class ResGirlDateMessage extends Message{

	private static Logger log = Logger.getLogger(ResGirlDateMessage.class);
	
	//妹子新的信息
	private GirlInfo girl;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//妹子新的信息
			writeBean(buf, this.girl);
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
			//妹子新的信息
			this.girl = (GirlInfo)readBean(buf, GirlInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 妹子新的信息
	 * @return 
	 */
	public GirlInfo getGirl(){
		return girl;
	}
	
	/**
	 * set 妹子新的信息
	 */
	public void setGirl(GirlInfo girl){
		this.girl = girl;
	}
	
	
	@Override
	public int getId() {
		return 108102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//妹子新的信息
		if(this.girl!=null) buf.append("girl:" + girl.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}