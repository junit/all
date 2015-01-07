package com.mokylin.game.server.logic.errormessage.message;

import java.util.List;
import java.util.ArrayList;

import com.mokylin.game.core.message.bean.Message;
import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 提示错误信息消息
 */
public class ResErrorMessage extends Message{

	private static Logger log = Logger.getLogger(ResErrorMessage.class);
	
	//错误信息编号
	private Integer errorId;
	//错误信息参数
	private List<String> errorMsgParam = new ArrayList<>();
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//错误信息编号
			writeInt(buf, this.errorId);
			//错误信息参数
			writeShort(buf, (short)errorMsgParam.size());
			for (int i = 0; i < errorMsgParam.size(); i++) {
				writeString(buf, errorMsgParam.get(i));
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
			//错误信息编号
			this.errorId = readInt(buf);
			//错误信息参数
			int errorMsgParam_length = readShort(buf);
			for (int i = 0; i < errorMsgParam_length; i++) {
				errorMsgParam.add(readString(buf));
			}
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 错误信息编号
	 * @return 
	 */
	public Integer getErrorId(){
		return errorId;
	}
	
	/**
	 * set 错误信息编号
	 */
	public void setErrorId(Integer errorId){
		this.errorId = errorId;
	}
	
	/**
	 * get 错误信息参数
	 * @return 
	 */
	public List<String> getErrorMsgParam(){
		return errorMsgParam;
	}
	
	/**
	 * set 错误信息参数
	 */
	public void setErrorMsgParam(List<String> errorMsgParam){
		this.errorMsgParam = errorMsgParam;
	}
	
	
	@Override
	public int getId() {
		return 201101;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//错误信息编号
		buf.append("errorId:" + errorId +",");
		//错误信息参数
		buf.append("errorMsgParam:{");
		for (int i = 0; i < errorMsgParam.size(); i++) {
			buf.append(errorMsgParam.get(i).toString() +",");
		}
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("},");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}