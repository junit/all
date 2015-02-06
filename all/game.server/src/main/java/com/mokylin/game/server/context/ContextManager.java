package com.mokylin.game.server.context;

import io.netty.channel.ChannelHandlerContext;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.server.ManagerPool;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.logic.map.Map;
import com.mokylin.game.server.logic.role.Role;

public class ContextManager {
	private Logger logger = Logger.getLogger(this.getClass());
	private ConcurrentHashMap<Long, ChannelHandlerContext> contexts = new ConcurrentHashMap<>();
	
	public ConcurrentHashMap<Long, ChannelHandlerContext> getContexts() {
		return contexts;
	}
	
	public void write(ChannelHandlerContext ctx, Message msg) {
		ContextUtil.write(ctx, msg);
	}

	public void write(Account account, Message msg) {
		try {
			write(contexts.get(account.getId()), msg);
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
	
	public void writeRound(Role role, Message msg) {
		try {
			Map map = ManagerPool.map.getMap(role);
			Collection<Role> roles = map.getRoundRoles(role.getMap().getCoordinate());
			for (Role tmpRole : roles) {
				write(tmpRole.getAccount(), msg);
			}
			
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
}
