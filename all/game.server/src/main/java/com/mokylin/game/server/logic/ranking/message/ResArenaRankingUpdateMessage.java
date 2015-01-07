package com.mokylin.game.server.logic.ranking.message;


import com.mokylin.game.server.logic.ranking.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 竞技场排行榜改变消息
 */
public class ResArenaRankingUpdateMessage extends Message{

	private static Logger log = Logger.getLogger(ResArenaRankingUpdateMessage.class);
	
	//竞技场排行榜数据
	private ArenaRankingBean arenaRankingData;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//竞技场排行榜数据
			writeBean(buf, this.arenaRankingData);
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
			//竞技场排行榜数据
			this.arenaRankingData = (ArenaRankingBean)readBean(buf, ArenaRankingBean.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 竞技场排行榜数据
	 * @return 
	 */
	public ArenaRankingBean getArenaRankingData(){
		return arenaRankingData;
	}
	
	/**
	 * set 竞技场排行榜数据
	 */
	public void setArenaRankingData(ArenaRankingBean arenaRankingData){
		this.arenaRankingData = arenaRankingData;
	}
	
	
	@Override
	public int getId() {
		return 209102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//竞技场排行榜数据
		if(this.arenaRankingData!=null) buf.append("arenaRankingData:" + arenaRankingData.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}