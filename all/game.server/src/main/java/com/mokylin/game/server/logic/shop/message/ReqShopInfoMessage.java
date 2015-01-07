package com.mokylin.game.server.logic.shop.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 请求商店所有道具信息消息
 */
public class ReqShopInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ReqShopInfoMessage.class);
	
	//商店类型(1:浦原商店, 2:竞技商店)
	private Integer type;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//商店类型(1:浦原商店, 2:竞技商店)
			writeInt(buf, this.type);
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
			//商店类型(1:浦原商店, 2:竞技商店)
			this.type = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 商店类型(1:浦原商店, 2:竞技商店)
	 * @return 
	 */
	public Integer getType(){
		return type;
	}
	
	/**
	 * set 商店类型(1:浦原商店, 2:竞技商店)
	 */
	public void setType(Integer type){
		this.type = type;
	}
	
	
	@Override
	public int getId() {
		return 104201;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//商店类型(1:浦原商店, 2:竞技商店)
		buf.append("type:" + type +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}