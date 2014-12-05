package com.mokylin.game.server.logic.role;

import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.role.consts.Sex;
import com.mokylin.game.server.logic.role.message.RoleInfo;
import com.mokylin.game.server.proto.RoleProto;
import com.mokylin.game.server.proto.RoleProto.RoleData;

public class Role {
	private long id;
	private String name;
	private Sex sex = Sex.MALE;

	private transient Account account;

	public RoleInfo getInfo() {
		RoleInfo info = new RoleInfo();
		info.setId(id);
		info.setName(name);
		info.setSex(sex.getValue());
		return info;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public static Role create(byte[] data) throws Exception {
		RoleData proto = RoleProto.RoleData.parseFrom(data);
		
		Role role = new Role();
		role.setId(proto.getId());
		role.setName(proto.getName());
		role.setSex(Sex.get((byte) proto.getSex()));
		
		return role;
	}

	public byte[] toBytes() {
		com.mokylin.game.server.proto.RoleProto.RoleData.Builder builder = RoleProto.RoleData.newBuilder();

		builder.setId(this.getId());
		builder.setName(this.getName());
		builder.setSex(this.getSex().getValue());
		
		return builder.build().toByteArray();
	}

}
