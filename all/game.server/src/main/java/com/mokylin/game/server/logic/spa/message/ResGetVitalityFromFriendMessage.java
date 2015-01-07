package com.mokylin.game.server.logic.spa.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回从好友那里获得的活力信息(好友邀请我泡温泉获得的活力)消息
 */
public class ResGetVitalityFromFriendMessage extends Message{

	private static Logger log = Logger.getLogger(ResGetVitalityFromFriendMessage.class);
	
	//好友邀请我泡温泉获得的活力结果消息Id
	private Integer msg;
	//好友id
	private Long friendId;
	//好友姓名
	private String friendName;
	//好友邀请我泡温泉获得的活力值
	private Integer vitality;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//好友邀请我泡温泉获得的活力结果消息Id
			writeInt(buf, this.msg);
			//好友id
			writeLong(buf, this.friendId);
			//好友姓名
			writeString(buf, this.friendName);
			//好友邀请我泡温泉获得的活力值
			writeInt(buf, this.vitality);
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
			//好友邀请我泡温泉获得的活力结果消息Id
			this.msg = readInt(buf);
			//好友id
			this.friendId = readLong(buf);
			//好友姓名
			this.friendName = readString(buf);
			//好友邀请我泡温泉获得的活力值
			this.vitality = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 好友邀请我泡温泉获得的活力结果消息Id
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 好友邀请我泡温泉获得的活力结果消息Id
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
	}
	
	/**
	 * get 好友id
	 * @return 
	 */
	public Long getFriendId(){
		return friendId;
	}
	
	/**
	 * set 好友id
	 */
	public void setFriendId(Long friendId){
		this.friendId = friendId;
	}
	
	/**
	 * get 好友姓名
	 * @return 
	 */
	public String getFriendName(){
		return friendName;
	}
	
	/**
	 * set 好友姓名
	 */
	public void setFriendName(String friendName){
		this.friendName = friendName;
	}
	
	/**
	 * get 好友邀请我泡温泉获得的活力值
	 * @return 
	 */
	public Integer getVitality(){
		return vitality;
	}
	
	/**
	 * set 好友邀请我泡温泉获得的活力值
	 */
	public void setVitality(Integer vitality){
		this.vitality = vitality;
	}
	
	
	@Override
	public int getId() {
		return 300103;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//好友邀请我泡温泉获得的活力结果消息Id
		buf.append("msg:" + msg +",");
		//好友id
		buf.append("friendId:" + friendId +",");
		//好友姓名
		if(this.friendName!=null) buf.append("friendName:" + friendName.toString() +",");
		//好友邀请我泡温泉获得的活力值
		buf.append("vitality:" + vitality +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}