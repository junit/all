package com.mokylin.game.robot.logic.spa.message;


import com.mokylin.game.robot.logic.spa.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回进入温泉结果消息消息
 */
public class ResEnterSpaMessage extends Message{

	private static Logger log = Logger.getLogger(ResEnterSpaMessage.class);
	
	//进入温泉结果消息Id(0：成功,非0：失败的消息Id)
	private Integer msg;
	//好友名称
	private String friendName;
	//温泉奖励
	private SpaReward spaReward;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//进入温泉结果消息Id(0：成功,非0：失败的消息Id)
			writeInt(buf, this.msg);
			//好友名称
			writeString(buf, this.friendName);
			//温泉奖励
			writeBean(buf, this.spaReward);
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
			//进入温泉结果消息Id(0：成功,非0：失败的消息Id)
			this.msg = readInt(buf);
			//好友名称
			this.friendName = readString(buf);
			//温泉奖励
			this.spaReward = (SpaReward)readBean(buf, SpaReward.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 进入温泉结果消息Id(0：成功,非0：失败的消息Id)
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 进入温泉结果消息Id(0：成功,非0：失败的消息Id)
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
	}
	
	/**
	 * get 好友名称
	 * @return 
	 */
	public String getFriendName(){
		return friendName;
	}
	
	/**
	 * set 好友名称
	 */
	public void setFriendName(String friendName){
		this.friendName = friendName;
	}
	
	/**
	 * get 温泉奖励
	 * @return 
	 */
	public SpaReward getSpaReward(){
		return spaReward;
	}
	
	/**
	 * set 温泉奖励
	 */
	public void setSpaReward(SpaReward spaReward){
		this.spaReward = spaReward;
	}
	
	
	@Override
	public int getId() {
		return 300101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//进入温泉结果消息Id(0：成功,非0：失败的消息Id)
		buf.append("msg:" + msg +",");
		//好友名称
		if(this.friendName!=null) buf.append("friendName:" + friendName.toString() +",");
		//温泉奖励
		if(this.spaReward!=null) buf.append("spaReward:" + spaReward.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}