package com.mokylin.game.robot.logic.girl.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 设置妹子时装消息
 */
public class ReqGirlDressMessage extends Message{

	private static Logger log = Logger.getLogger(ReqGirlDressMessage.class);
	
	//妹子id
	private Integer girlId;
	//当前时装id
	private Integer nowDress;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//妹子id
			writeInt(buf, this.girlId);
			//当前时装id
			writeInt(buf, this.nowDress);
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
			//妹子id
			this.girlId = readInt(buf);
			//当前时装id
			this.nowDress = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 妹子id
	 * @return 
	 */
	public Integer getGirlId(){
		return girlId;
	}
	
	/**
	 * set 妹子id
	 */
	public void setGirlId(Integer girlId){
		this.girlId = girlId;
	}
	
	/**
	 * get 当前时装id
	 * @return 
	 */
	public Integer getNowDress(){
		return nowDress;
	}
	
	/**
	 * set 当前时装id
	 */
	public void setNowDress(Integer nowDress){
		this.nowDress = nowDress;
	}
	
	
	@Override
	public int getId() {
		return 108203;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//妹子id
		buf.append("girlId:" + girlId +",");
		//当前时装id
		buf.append("nowDress:" + nowDress +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}