package com.mokylin.game.server.logic.role;

import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.map.MapRoleData;
import com.mokylin.game.server.logic.role.consts.Sex;
import com.mokylin.game.server.logic.role.message.RoleInfo;

public class Role {
	private long id;
	private String name;
	private Sex sex = Sex.MALE;
	private MapRoleData map = new MapRoleData();

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

	public MapRoleData getMap() {
		return map;
	}

	public void setMap(MapRoleData map) {
		this.map = map;
	}

}
