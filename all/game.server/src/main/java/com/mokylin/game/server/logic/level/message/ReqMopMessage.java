package com.mokylin.game.server.logic.level.message;


import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 前端请求扫荡消息
 */
public class ReqMopMessage extends Message{

	private static Logger log = Logger.getLogger(ReqMopMessage.class);
	
	//关卡难度id
	private Integer levelDifficultyId;
	//扫荡次数
	private Integer num;
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//关卡难度id
			writeInt(buf, this.levelDifficultyId);
			//扫荡次数
			writeInt(buf, this.num);
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
			//关卡难度id
			this.levelDifficultyId = readInt(buf);
			//扫荡次数
			this.num = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 关卡难度id
	 * @return 
	 */
	public Integer getLevelDifficultyId(){
		return levelDifficultyId;
	}
	
	/**
	 * set 关卡难度id
	 */
	public void setLevelDifficultyId(Integer levelDifficultyId){
		this.levelDifficultyId = levelDifficultyId;
	}
	
	/**
	 * get 扫荡次数
	 * @return 
	 */
	public Integer getNum(){
		return num;
	}
	
	/**
	 * set 扫荡次数
	 */
	public void setNum(Integer num){
		this.num = num;
	}
	
	
	@Override
	public int getId() {
		return 102203;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//关卡难度id
		buf.append("levelDifficultyId:" + levelDifficultyId +",");
		//扫荡次数
		buf.append("num:" + num +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}