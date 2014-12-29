package com.mokylin.game.robot.logic.girl.bean;


import com.mokylin.game.core.message.bean.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 获取妹子的条件信息
 */
public class GirlGetConditionInfo extends Bean {

	private static Logger log = Logger.getLogger(GirlGetConditionInfo.class);
	
	//1:泡温泉次数 2:浦原商店购物次数 3:进阶次数 4:料理次数 5:连续登录天数 6:竞技场排名
	private Byte type;
	
	//对应type的值
	private Integer value;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//1:泡温泉次数 2:浦原商店购物次数 3:进阶次数 4:料理次数 5:连续登录天数 6:竞技场排名
			writeByte(buf, this.type);
			//对应type的值
			writeInt(buf, this.value);
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
			//1:泡温泉次数 2:浦原商店购物次数 3:进阶次数 4:料理次数 5:连续登录天数 6:竞技场排名
			this.type = readByte(buf);
			//对应type的值
			this.value = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 1:泡温泉次数 2:浦原商店购物次数 3:进阶次数 4:料理次数 5:连续登录天数 6:竞技场排名
	 * @return 
	 */
	public Byte getType(){
		return type;
	}
	
	/**
	 * set 1:泡温泉次数 2:浦原商店购物次数 3:进阶次数 4:料理次数 5:连续登录天数 6:竞技场排名
	 */
	public void setType(Byte type){
		this.type = type;
	}
	
	/**
	 * get 对应type的值
	 * @return 
	 */
	public Integer getValue(){
		return value;
	}
	
	/**
	 * set 对应type的值
	 */
	public void setValue(Integer value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//1:泡温泉次数 2:浦原商店购物次数 3:进阶次数 4:料理次数 5:连续登录天数 6:竞技场排名
		buf.append("type:" + type +",");
		//对应type的值
		buf.append("value:" + value +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}