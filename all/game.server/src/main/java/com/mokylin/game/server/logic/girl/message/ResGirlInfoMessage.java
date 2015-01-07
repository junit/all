package com.mokylin.game.server.logic.girl.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.server.logic.girl.bean.*;
import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 妹子信息消息
 */
public class ResGirlInfoMessage extends Message{

	private static Logger log = Logger.getLogger(ResGirlInfoMessage.class);
	
	//对手信息
	private List<GirlInfo> infos = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//对手信息
			writeShort(buf, (short)infos.size());
			for (int i = 0; i < infos.size(); i++) {
				writeBean(buf, infos.get(i));
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
			//对手信息
			int infos_length = readShort(buf);
			for (int i = 0; i < infos_length; i++) {
				infos.add((GirlInfo)readBean(buf, GirlInfo.class));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 对手信息
	 * @return 
	 */
	public List<GirlInfo> getInfos(){
		return infos;
	}
	
	/**
	 * set 对手信息
	 */
	public void setInfos(List<GirlInfo> infos){
		this.infos = infos;
	}
	
	
	@Override
	public int getId() {
		return 108101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//对手信息
		buf.append("infos:{");
		for (int i = 0; i < infos.size(); i++) {
			buf.append(infos.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}