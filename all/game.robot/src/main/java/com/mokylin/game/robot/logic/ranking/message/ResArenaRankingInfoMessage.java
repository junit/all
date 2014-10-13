package com.mokylin.game.robot.logic.ranking.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.robot.logic.ranking.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 竞技场排行榜消息
 */
public class ResArenaRankingInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResArenaRankingInfoMessage.class);
	
	//竞技场排行榜数据
	private List<ArenaRankingBean> arenaRankingData = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//竞技场排行榜数据
			writeShort(buf, (short)arenaRankingData.size());
			for (int i = 0; i < arenaRankingData.size(); i++) {
				writeBean(buf, arenaRankingData.get(i));
			}
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
			int arenaRankingData_length = readShort(buf);
			for (int i = 0; i < arenaRankingData_length; i++) {
				arenaRankingData.add((ArenaRankingBean)readBean(buf, ArenaRankingBean.class));
			}
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
	public List<ArenaRankingBean> getArenaRankingData(){
		return arenaRankingData;
	}
	
	/**
	 * set 竞技场排行榜数据
	 */
	public void setArenaRankingData(List<ArenaRankingBean> arenaRankingData){
		this.arenaRankingData = arenaRankingData;
	}
	
	
	@Override
	public int getId() {
		return 209101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//竞技场排行榜数据
		buf.append("arenaRankingData:{");
		for (int i = 0; i < arenaRankingData.size(); i++) {
			buf.append(arenaRankingData.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}