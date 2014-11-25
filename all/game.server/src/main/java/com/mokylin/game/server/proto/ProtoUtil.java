package com.mokylin.game.server.proto;

import org.apache.log4j.Logger;

import com.mokylin.game.server.logic.map.MapRoleData;
import com.mokylin.game.server.logic.role.Role;
import com.mokylin.game.server.logic.role.consts.Sex;
import com.mokylin.game.server.proto.bean.MapProto;
import com.mokylin.game.server.proto.bean.MapProto.MapDataProto;
import com.mokylin.game.server.proto.bean.RoleProto;
import com.mokylin.game.server.proto.bean.RoleProto.RoleDataProto;
import com.mokylin.game.server.proto.bean.RoleProto.RoleDataProto.Builder;

public class ProtoUtil {
	private static Logger logger = Logger.getLogger(ProtoUtil.class);

	public static byte[] toBytes(Role role) {
		Builder builder = RoleProto.RoleDataProto.newBuilder();

		builder.setId(role.getId());
		builder.setName(role.getName());
		builder.setSex(role.getSex().getValue());
		
		builder.setMap(getMapData(role));

		return builder.build().toByteArray();
	}

	public static Role createRole(byte[] data) {
		try {
			RoleDataProto proto = RoleProto.RoleDataProto.parseFrom(data);
			
			Role role = new Role();
			role.setId(proto.getId());
			role.setName(proto.getName());
			role.setSex(Sex.get((byte) proto.getSex()));
			
			role.setMap(getMap(proto.getMap()));
			
			return role;
		} catch (Exception e) {
			logger.error(e, e);
		}
		return null;
	}

	private static MapRoleData getMap(MapDataProto map) {
		MapRoleData data = new MapRoleData();
		data.setModel(map.getModel());
		data.getCoordinate().setX(map.getX());
		data.getCoordinate().setY(map.getY());
		return data;
	}

	private static MapDataProto getMapData(Role role) {
		com.mokylin.game.server.proto.bean.MapProto.MapDataProto.Builder builder = MapProto.MapDataProto.newBuilder();

		builder.setModel(role.getMap().getModel());
		builder.setX(role.getMap().getCoordinate().getX());
		builder.setY(role.getMap().getCoordinate().getY());

		return builder.build();
	}
}
