package com.mokylin.game.robot.logic.character.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 解锁角色回复消息
 */
public class ResUnLockCharacterMessage extends Message{

	private static Logger log = Logger.getLogger(ResUnLockCharacterMessage.class);
	
	//角色解锁结果(0:成功，1：灵魂不足，
	private Byte result;
	//解锁获得的角色id(解锁失败时为0)
	private Integer charId;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色解锁结果(0:成功，1：灵魂不足，
			writeByte(buf, this.result);
			//解锁获得的角色id(解锁失败时为0)
			writeInt(buf, this.charId);
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
			//角色解锁结果(0:成功，1：灵魂不足，
			this.result = readByte(buf);
			//解锁获得的角色id(解锁失败时为0)
			this.charId = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色解锁结果(0:成功，1：灵魂不足，
	 * @return 
	 */
	public Byte getResult(){
		return result;
	}
	
	/**
	 * set 角色解锁结果(0:成功，1：灵魂不足，
	 */
	public void setResult(Byte result){
		this.result = result;
	}
	
	/**
	 * get 解锁获得的角色id(解锁失败时为0)
	 * @return 
	 */
	public Integer getCharId(){
		return charId;
	}
	
	/**
	 * set 解锁获得的角色id(解锁失败时为0)
	 */
	public void setCharId(Integer charId){
		this.charId = charId;
	}
	
	
	@Override
	public int getId() {
		return 200201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色解锁结果(0:成功，1：灵魂不足，
		buf.append("result:" + result +",");
		//解锁获得的角色id(解锁失败时为0)
		buf.append("charId:" + charId +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}