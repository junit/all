package com.mokylin.game.server.logic.map.message;


import com.mokylin.game.core.message.Bean;

import io.netty.buffer.ByteBuf;
import org.apache.log4j.Logger;

/** 
 * @author messageGenerator
 * 
 * @version 1.0.0
 * 
 * 地图角色信息
 */
public class MapRoleInfo extends Bean {

	private static Logger log = Logger.getLogger(MapRoleInfo.class);
	
	//角色Id
	private Long id;
	
	//角色名称
	private String name;
	
	//性别
	private Byte sex;
	
	//坐标
	private CoordinateInfo coordinate;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(ByteBuf buf){
	    try {
			//角色Id
			writeLong(buf, this.id);
			//角色名称
			writeString(buf, this.name);
			//性别
			writeByte(buf, this.sex);
			//坐标
			writeBean(buf, this.coordinate);
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
			//角色Id
			this.id = readLong(buf);
			//角色名称
			this.name = readString(buf);
			//性别
			this.sex = readByte(buf);
			//坐标
			this.coordinate = (CoordinateInfo)readBean(buf, CoordinateInfo.class);
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
        return true;
	}
	
	/**
	 * get 角色Id
	 * @return 
	 */
	public Long getId(){
		return id;
	}
	
	/**
	 * set 角色Id
	 */
	public void setId(Long id){
		this.id = id;
	}
	
	/**
	 * get 角色名称
	 * @return 
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * set 角色名称
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * get 性别
	 * @return 
	 */
	public Byte getSex(){
		return sex;
	}
	
	/**
	 * set 性别
	 */
	public void setSex(Byte sex){
		this.sex = sex;
	}
	
	/**
	 * get 坐标
	 * @return 
	 */
	public CoordinateInfo getCoordinate(){
		return coordinate;
	}
	
	/**
	 * set 坐标
	 */
	public void setCoordinate(CoordinateInfo coordinate){
		this.coordinate = coordinate;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//角色Id
		buf.append("id:" + id +",");
		//角色名称
		if(this.name!=null) buf.append("name:" + name.toString() +",");
		//性别
		buf.append("sex:" + sex +",");
		//坐标
		if(this.coordinate!=null) buf.append("coordinate:" + coordinate.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}