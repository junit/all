package com.mokylin.game.server.logic.role;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mokylin.game.core.common.IdFactory;
import com.mokylin.game.server.context.ContextManager;
import com.mokylin.game.server.db.data.bean.RoleBean;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.role.consts.Sex;
import com.mokylin.game.server.logic.role.message.ReqRoleCreateMessage;
import com.mokylin.game.server.logic.role.message.ResRoleCreateMessage;
import com.mokylin.game.server.logic.role.message.RoleInfo;
import com.mokylin.game.server.name.NameManager;

@Singleton
public class RoleManager {
	private Logger logger = Logger.getLogger(this.getClass());
	private final RoleCache cache;
	private final NameManager nameManager;
	private final ContextManager contextManager;
	private final IdFactory idFactory;
	
	@Inject
	public RoleManager(NameManager nameManager, ContextManager contextManager, RoleCache cache, IdFactory factory) {
		this.nameManager = nameManager;
		this.contextManager = contextManager;
		this.cache = cache;
		this.idFactory = factory;
	}

	public List<Role> getRoles(Account account) {
		return cache.getRoles(account);
	}

	public void put(Account account, List<RoleBean> list) {
		Vector<Role> roles = new Vector<Role>();
		
		for (RoleBean bean : list) {
			try {
				Role role = Role.create(bean.getData());
				roles.add(role);
			} catch (Exception e) {
				logger.error(e, e);
			}
		}
		
		cache.put(account, roles);
	}

	public List<RoleInfo> getRoleInfoList(Account account, List<RoleInfo> list) {
		List<Role> roles = getRoles(account);
		for (Role role : roles) {
			list.add(role.getInfo());
		}
		return list;
	}

	public void create(Account account, ReqRoleCreateMessage msg) {
		String name = nameManager.createValidName(account.getServer(), msg.getName());
		if (name == null) {
			logger.info("名字重复啦:" + msg.getName());
			return ;
		}
		
		Role role = new Role();
		role.setId(idFactory.uid(account.getPlatform().getValue(), account.getServer()));
		role.setSex(Sex.get(msg.getSex()));
		role.setName(name);
		init(role);
		
//		final RoleBean bean = create(account, role);
//		try {
//			ManagerPool.thread.getSaveThreadGroup().add(account, new Event() {
//				@Override
//				public void exec() throws Exception {
//					DaoPool.roleDao.insert(bean);
//				}
//				
//				@Override
//				public int timeOutMs() {
//					return 100;
//				}
//			});
//		} catch (Exception e) {
//			logger.error(e, e);
//		}
		send(account, role);
	}

	private static AtomicLong s = new AtomicLong(0);
	
	private RoleBean create(Account account, Role role) {
		RoleBean bean = new RoleBean();
		bean.setId(role.getId());
		bean.setAccount(account.getId());
		
		long s1 = System.currentTimeMillis();
		bean.setData(role.toBytes());
//		bean.setData(JSON.toJSONBytes(role));
		long s2 = System.currentTimeMillis();
		s.addAndGet(s2 - s1);
		System.err.println("总共:" + s);
		
		return bean;
	}

	private void send(Account account, Role role) {
		ResRoleCreateMessage msg = new ResRoleCreateMessage();
		msg.setRole(role.getInfo());
		contextManager.write(account, msg);
	}

	private void init(Role role) {
		// TODO 暂时不需要
	}

	public Role getRole(int id) {
		return cache.getRole(id);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		Role role = new Role();
		role.setId(123);
		role.setName("abc");
		int count = 1000000;
		byte[] proto_buf = null;
		byte[] json_buf = null;
		long s1 = System.currentTimeMillis();
		for (int i = 0; i < count; ++i) {
			proto_buf = role.toBytes();
		}
		
		long s2 = System.currentTimeMillis();
		for (int i = 0; i < count; ++i) {
//			json_buf = JSON.toJSONBytes(role, SerializerFeature.WriteClassName);
		}
		long s3 = System.currentTimeMillis();
		System.err.println("序列化测试proto:" + (s2 - s1) + ":" + proto_buf.length + ",json:" + (s3 - s2) + ":" + json_buf.length);
		
		long s4 = System.currentTimeMillis();
		for (int i = 0; i < count; ++i) {
			Role create = Role.create(proto_buf);
		}
		long s5 = System.currentTimeMillis();
		for (int i = 0; i < count; ++i) {
//			Role r = JSON.parseObject(json_buf, Role.class);
		}
		long s6 = System.currentTimeMillis();
		System.err.println("反序列化测试proto:" + (s5 - s4) + ",json:" + (s6 - s5));
	}
}
