package com.mokylin.game.server.logic.shop.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 购买道具返回，成功的话，客户端自己刷新商店消息
 */
public class ResShopBuyMessage extends Message{

	private static Logger log = Logger.getLogger(ResShopBuyMessage.class);
	
	//商店类型(1:浦原商店, 2:竞技商店)
	private Integer type;
	//index 大于 0的时候表示操作成功，为序号。index 小于 0表示失败
	private Integer index;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//商店类型(1:浦原商店, 2:竞技商店)
			writeInt(buf, this.type);
			//index 大于 0的时候表示操作成功，为序号。index 小于 0表示失败
			writeInt(buf, this.index);
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
			//index 大于 0的时候表示操作成功，为序号。index 小于 0表示失败
			this.index = readInt(buf);
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
	
	/**
	 * get index 大于 0的时候表示操作成功，为序号。index 小于 0表示失败
	 * @return 
	 */
	public Integer getIndex(){
		return index;
	}
	
	/**
	 * set index 大于 0的时候表示操作成功，为序号。index 小于 0表示失败
	 */
	public void setIndex(Integer index){
		this.index = index;
	}
	
	
	@Override
	public int getId() {
		return 104102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//商店类型(1:浦原商店, 2:竞技商店)
		buf.append("type:" + type +",");
		//index 大于 0的时候表示操作成功，为序号。index 小于 0表示失败
		buf.append("index:" + index +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}