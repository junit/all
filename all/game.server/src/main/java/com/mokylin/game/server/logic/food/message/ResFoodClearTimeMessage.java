package com.mokylin.game.server.logic.food.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 饱食度（倒计时进度条）消息
 */
public class ResFoodClearTimeMessage extends Message{

	private static Logger log = Logger.getLogger(ResFoodClearTimeMessage.class);
	
	//下次可以料理的时间距离当前时间的秒数
	private Integer nextCookTime;
	//cd总时间
	private Integer cd;
	//已经吃过的特供料理中最大的id
	private Integer specialMax;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//下次可以料理的时间距离当前时间的秒数
			writeInt(buf, this.nextCookTime);
			//cd总时间
			writeInt(buf, this.cd);
			//已经吃过的特供料理中最大的id
			writeInt(buf, this.specialMax);
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
			//下次可以料理的时间距离当前时间的秒数
			this.nextCookTime = readInt(buf);
			//cd总时间
			this.cd = readInt(buf);
			//已经吃过的特供料理中最大的id
			this.specialMax = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 下次可以料理的时间距离当前时间的秒数
	 * @return 
	 */
	public Integer getNextCookTime(){
		return nextCookTime;
	}
	
	/**
	 * set 下次可以料理的时间距离当前时间的秒数
	 */
	public void setNextCookTime(Integer nextCookTime){
		this.nextCookTime = nextCookTime;
	}
	
	/**
	 * get cd总时间
	 * @return 
	 */
	public Integer getCd(){
		return cd;
	}
	
	/**
	 * set cd总时间
	 */
	public void setCd(Integer cd){
		this.cd = cd;
	}
	
	/**
	 * get 已经吃过的特供料理中最大的id
	 * @return 
	 */
	public Integer getSpecialMax(){
		return specialMax;
	}
	
	/**
	 * set 已经吃过的特供料理中最大的id
	 */
	public void setSpecialMax(Integer specialMax){
		this.specialMax = specialMax;
	}
	
	
	@Override
	public int getId() {
		return 106102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//下次可以料理的时间距离当前时间的秒数
		buf.append("nextCookTime:" + nextCookTime +",");
		//cd总时间
		buf.append("cd:" + cd +",");
		//已经吃过的特供料理中最大的id
		buf.append("specialMax:" + specialMax +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}