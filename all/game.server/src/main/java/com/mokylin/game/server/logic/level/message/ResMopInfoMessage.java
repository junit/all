package com.mokylin.game.server.logic.level.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.server.logic.level.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 返回扫荡结果信息消息
 */
public class ResMopInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResMopInfoMessage.class);
	
	//扫荡结果消息Id(0：成功,非0：失败的消息Id)
	private Integer msg;
	//扫荡奖励
	private List<LevelRewardInfo> levelRewardInfos = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//扫荡结果消息Id(0：成功,非0：失败的消息Id)
			writeInt(buf, this.msg);
			//扫荡奖励
			writeShort(buf, (short)levelRewardInfos.size());
			for (int i = 0; i < levelRewardInfos.size(); i++) {
				writeBean(buf, levelRewardInfos.get(i));
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
			//扫荡结果消息Id(0：成功,非0：失败的消息Id)
			this.msg = readInt(buf);
			//扫荡奖励
			int levelRewardInfos_length = readShort(buf);
			for (int i = 0; i < levelRewardInfos_length; i++) {
				levelRewardInfos.add((LevelRewardInfo)readBean(buf, LevelRewardInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 扫荡结果消息Id(0：成功,非0：失败的消息Id)
	 * @return 
	 */
	public Integer getMsg(){
		return msg;
	}
	
	/**
	 * set 扫荡结果消息Id(0：成功,非0：失败的消息Id)
	 */
	public void setMsg(Integer msg){
		this.msg = msg;
	}
	
	/**
	 * get 扫荡奖励
	 * @return 
	 */
	public List<LevelRewardInfo> getLevelRewardInfos(){
		return levelRewardInfos;
	}
	
	/**
	 * set 扫荡奖励
	 */
	public void setLevelRewardInfos(List<LevelRewardInfo> levelRewardInfos){
		this.levelRewardInfos = levelRewardInfos;
	}
	
	
	@Override
	public int getId() {
		return 102102;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//扫荡结果消息Id(0：成功,非0：失败的消息Id)
		buf.append("msg:" + msg +",");
		//扫荡奖励
		buf.append("levelRewardInfos:{");
		for (int i = 0; i < levelRewardInfos.size(); i++) {
			buf.append(levelRewardInfos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}