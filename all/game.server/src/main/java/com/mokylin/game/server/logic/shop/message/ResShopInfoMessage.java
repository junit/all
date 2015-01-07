package com.mokylin.game.server.logic.shop.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.server.logic.shop.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 商店所有道具信息（上线和改变的时候会发送，前端也可主动请求）消息
 */
public class ResShopInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResShopInfoMessage.class);
	
	//商店类型(1:浦原商店, 2:竞技商店)
	private Integer type;
	//道具信息
	private List<ShopItemInfo> info = new ArrayList<>();
	//下次刷新时间距离当前的秒数
	private Integer nextRefreshTime;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//商店类型(1:浦原商店, 2:竞技商店)
			writeInt(buf, this.type);
			//道具信息
			writeShort(buf, (short)info.size());
			for (int i = 0; i < info.size(); i++) {
				writeBean(buf, info.get(i));
			}
			//下次刷新时间距离当前的秒数
			writeInt(buf, this.nextRefreshTime);
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
			//道具信息
			int info_length = readShort(buf);
			for (int i = 0; i < info_length; i++) {
				info.add((ShopItemInfo)readBean(buf, ShopItemInfo.class));
			}
			//下次刷新时间距离当前的秒数
			this.nextRefreshTime = readInt(buf);
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
	 * get 道具信息
	 * @return 
	 */
	public List<ShopItemInfo> getInfo(){
		return info;
	}
	
	/**
	 * set 道具信息
	 */
	public void setInfo(List<ShopItemInfo> info){
		this.info = info;
	}
	
	/**
	 * get 下次刷新时间距离当前的秒数
	 * @return 
	 */
	public Integer getNextRefreshTime(){
		return nextRefreshTime;
	}
	
	/**
	 * set 下次刷新时间距离当前的秒数
	 */
	public void setNextRefreshTime(Integer nextRefreshTime){
		this.nextRefreshTime = nextRefreshTime;
	}
	
	
	@Override
	public int getId() {
		return 104101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//商店类型(1:浦原商店, 2:竞技商店)
		buf.append("type:" + type +",");
		//道具信息
		buf.append("info:{");
		for (int i = 0; i < info.size(); i++) {
			buf.append(info.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		//下次刷新时间距离当前的秒数
		buf.append("nextRefreshTime:" + nextRefreshTime +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}