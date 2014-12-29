package com.mokylin.game.robot.logic.food.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 制作食物消息
 */
public class ReqFoodCookMessage extends Message{

	private static Logger log = Logger.getLogger(ReqFoodCookMessage.class);
	
	//食物Id
	private Integer foodId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//食物Id
			writeInt(buf, this.foodId);
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
			//食物Id
			this.foodId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 食物Id
	 * @return 
	 */
	public Integer getFoodId(){
		return foodId;
	}
	
	/**
	 * set 食物Id
	 */
	public void setFoodId(Integer foodId){
		this.foodId = foodId;
	}
	
	
	@Override
	public int getId() {
		return 106201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//食物Id
		buf.append("foodId:" + foodId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}