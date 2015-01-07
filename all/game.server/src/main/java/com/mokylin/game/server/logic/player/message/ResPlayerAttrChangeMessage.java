package com.mokylin.game.server.logic.player.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 同步玩家数据改变消息
 */
public class ResPlayerAttrChangeMessage extends Message{

	private static Logger log = Logger.getLogger(ResPlayerAttrChangeMessage.class);
	
	//属性id : 0-玩家等级 1-环 2-灵子 3-魂玉 4-体力 5-星数 6-经验
	private Integer AttrbuteId;
	//属性值
	private Integer AttrbuteValue;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//属性id : 0-玩家等级 1-环 2-灵子 3-魂玉 4-体力 5-星数 6-经验
			writeInt(buf, this.AttrbuteId);
			//属性值
			writeInt(buf, this.AttrbuteValue);
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
			//属性id : 0-玩家等级 1-环 2-灵子 3-魂玉 4-体力 5-星数 6-经验
			this.AttrbuteId = readInt(buf);
			//属性值
			this.AttrbuteValue = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 属性id : 0-玩家等级 1-环 2-灵子 3-魂玉 4-体力 5-星数 6-经验
	 * @return 
	 */
	public Integer getAttrbuteId(){
		return AttrbuteId;
	}
	
	/**
	 * set 属性id : 0-玩家等级 1-环 2-灵子 3-魂玉 4-体力 5-星数 6-经验
	 */
	public void setAttrbuteId(Integer AttrbuteId){
		this.AttrbuteId = AttrbuteId;
	}
	
	/**
	 * get 属性值
	 * @return 
	 */
	public Integer getAttrbuteValue(){
		return AttrbuteValue;
	}
	
	/**
	 * set 属性值
	 */
	public void setAttrbuteValue(Integer AttrbuteValue){
		this.AttrbuteValue = AttrbuteValue;
	}
	
	
	@Override
	public int getId() {
		return 105101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//属性id : 0-玩家等级 1-环 2-灵子 3-魂玉 4-体力 5-星数 6-经验
		buf.append("AttrbuteId:" + AttrbuteId +",");
		//属性值
		buf.append("AttrbuteValue:" + AttrbuteValue +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}