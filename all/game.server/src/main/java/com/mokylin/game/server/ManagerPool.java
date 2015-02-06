package com.mokylin.game.server;

import com.mokylin.game.core.scheduler.SchedulerManager;
import com.mokylin.game.server.config.ConfigManager;
import com.mokylin.game.server.context.ContextManager;
import com.mokylin.game.server.logic.account.AccountManager;
import com.mokylin.game.server.logic.map.MapManager;
import com.mokylin.game.server.logic.role.RoleManager;
import com.mokylin.game.server.name.NameManager;
import com.mokylin.game.server.thread.ThreadManager;

public class ManagerPool {
	public static MessageManager message = new MessageManager(); // 消息管理
	public static AccountManager account = new AccountManager(); // 帐号管理
	public static SchedulerManager scheduler = new SchedulerManager(); // 调度管理
	public static ContextManager context = new ContextManager(); // 网络上下文管理
	public static ConfigManager config = new ConfigManager(); // 配置管理
	public static NameManager name = new NameManager(); // 名字管理
	public static ThreadManager thread = new ThreadManager(); // 线程管理
	public static RoleManager role = new RoleManager(); // 角色管理
	public static MapManager map = new MapManager(); // 地图管理
}
