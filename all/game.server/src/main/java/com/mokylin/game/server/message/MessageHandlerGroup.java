package com.mokylin.game.server.message;

import java.util.HashMap;

import io.netty.channel.ChannelHandlerContext;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mokylin.game.core.event.GameEventHandler;
import com.mokylin.game.core.message.Message;
import com.mokylin.game.server.logic.account.Account;
import com.mokylin.game.server.message.impl.AccountHandler;
import com.mokylin.game.server.message.impl.CtxHandler;

@Singleton
public class MessageHandlerGroup {
	@SuppressWarnings("rawtypes")
	private HashMap<Integer, GameEventHandler> handlers = new HashMap<>();

	@SuppressWarnings("unchecked")
	public GameEventHandler<ChannelHandlerContext, Message> getCtxHandler(int id) {
		return handlers.get(id);
	}

	@SuppressWarnings("unchecked")
	public GameEventHandler<Account, Message> getAccountHandler(int id) {
		return handlers.get(id);
	}
	
	public MessageHandlerGroup() {
		handlers.put(1, new CtxHandler());
		handlers.put(2, new AccountHandler());
	}
}
