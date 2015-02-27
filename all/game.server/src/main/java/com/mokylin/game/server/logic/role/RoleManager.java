package com.mokylin.game.server.logic.role;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mokylin.game.core.message.Command;
import com.mokylin.game.core.util.CommonUtil;
import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.db.data.DaoPool;
import com.mokylin.game.server.db.data.bean.RoleBean;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.role.consts.Sex;
import com.mokylin.game.server.logic.role.message.ReqRoleCreateMessage;
import com.mokylin.game.server.logic.role.message.ResRoleCreateMessage;
import com.mokylin.game.server.logic.role.message.RoleInfo;
import com.mokylin.game.server.logic.role.proto.RoleProto;
import com.mokylin.game.server.logic.role.proto.RoleProto.Role.Builder;

public class RoleManager {
	private Logger logger = Logger.getLogger(this.getClass());
	private RoleCache cache = new RoleCache();

	public List<Role> getRoles(Account account) {
		return cache.getRoles(account);
	}

	public void put(Account account, List<RoleBean> list) {
		Vector<Role> roles = new Vector<Role>();
		
		for (RoleBean bean : list) {
			roles.add(create(bean));
		}
		
		cache.put(account, roles);
	}

	private Role create(RoleBean bean) {
		try {
			com.mokylin.game.server.logic.role.proto.RoleProto.Role roleProto = RoleProto.Role.parseFrom(bean.getData());
			Role role = new Role();
			role.setId(roleProto.getId());
			role.setName(roleProto.getName());
			role.setSex(Sex.get((byte) roleProto.getSex()));
			
			role.getMap().setModel(roleProto.getMapData().getModel());
			role.getMap().getCoordinate().setX(roleProto.getMapData().getX());
			role.getMap().getCoordinate().setY(roleProto.getMapData().getY());
			return role;
		} catch (InvalidProtocolBufferException e) {
			logger.error(e, e);
			return null;
		}
//		Role role = JSON.parseObject(bean.getData(), Role.class);
//		return role;
	}

	public List<RoleInfo> getRoleInfoList(Account account, List<RoleInfo> list) {
		List<Role> roles = getRoles(account);
		for (Role role : roles) {
			list.add(role.getInfo());
		}
		return list;
	}

	public void create(Account account, ReqRoleCreateMessage msg) {
		String name = ManagerPool.name.createValidName(account.getServer(), msg.getName());
		if (name == null) {
			logger.info("名字重复啦:" + msg.getName());
			return ;
		}
		
		Role role = new Role();
		role.setId(CommonUtil.uid(account.getPlatform().getValue(), account.getServer()));
		role.setSex(Sex.get(msg.getSex()));
		role.setName(name);
		init(role);
		
		final RoleBean bean = create(account, role);
		try {
			ManagerPool.thread.getSaveThreadGroup().add(account, new Command() {
				@Override
				public void exec() throws Exception {
					DaoPool.roleDao.insert(bean);
				}
				
				@Override
				public int timeOutMs() {
					return 100;
				}
			});
		} catch (Exception e) {
			logger.error(e, e);
		}
		send(account, role);
	}

	private static AtomicLong s = new AtomicLong(0);
	
	private RoleBean create(Account account, Role role) {
		RoleBean bean = new RoleBean();
		bean.setId(role.getId());
		bean.setAccount(account.getId());
		long s1 = System.currentTimeMillis();
		
		Builder builder = RoleProto.Role.newBuilder();
		com.mokylin.game.server.logic.role.proto.RoleProto.MapData.Builder mapBuilder = RoleProto.MapData.newBuilder();
		mapBuilder.setModel(role.getMap().getModel());
		mapBuilder.setX(role.getMap().getCoordinate().getX());
		mapBuilder.setY(role.getMap().getCoordinate().getY());
		
		builder.setId(role.getId());
		builder.setName(role.getName());
		builder.setSex(role.getSex().getValue());
		builder.setMapData(mapBuilder.build());
		
		bean.setData(builder.build().toByteArray());
		
//		bean.setData(JSON.toJSONBytes(role));
		long s2 = System.currentTimeMillis();
		s.addAndGet(s2 - s1);
		System.err.println("总共:" + s);
		return bean;
	}

	private void send(Account account, Role role) {
		ResRoleCreateMessage msg = new ResRoleCreateMessage();
		msg.setRole(role.getInfo());
		ManagerPool.context.write(account, msg);
	}

	private void init(Role role) {
		// TODO 暂时不需要
	}

	public Role getRole(int id) {
		return cache.getRole(id);
	}
}
