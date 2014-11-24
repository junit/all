package com.mokylin.game.server.logic.map.message;


import com.mokylin.game.core.message.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 坐标信息
 */
public class CoordinateInfo extends Bean {

	private static Logger log = Logger.getLogger(CoordinateInfo.class);
	
	//x
	private Integer x;
	
	//y
	private Integer y;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//x
			writeInt(buf, this.x);
			//y
			writeInt(buf, this.y);
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
			//x
			this.x = readInt(buf);
			//y
			this.y = readInt(buf);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get x
	 * @return 
	 */
	public Integer getX(){
		return x;
	}
	
	/**
	 * set x
	 */
	public void setX(Integer x){
		this.x = x;
	}
	
	/**
	 * get y
	 * @return 
	 */
	public Integer getY(){
		return y;
	}
	
	/**
	 * set y
	 */
	public void setY(Integer y){
		this.y = y;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//x
		buf.append("x:" + x +",");
		//y
		buf.append("y:" + y +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}