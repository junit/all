package com.mokylin.game.server.event;

import io.netty.channel.ChannelHandlerContext;

import com.google.inject.Singleton;
import com.mokylin.game.core.event.Excutor;
import com.mokylin.game.core.message.Message;
import com.mokylin.game.server.logic.account.Account;

@Singleton
public class ExcutorGroup {
	private Excutor<ChannelHandlerContext, Message> loginExcutor;
	private Excutor<Account, Message> accountExcutor;
	
	public ExcutorGroup() throws Exception {
		loginExcutor = new Excutor<>("login-excutor", Thread.MAX_PRIORITY, 64 * 1024);
		accountExcutor = new Excutor<>("account-excutor", Thread.MAX_PRIORITY, 128 * 1024);
	}
	
	public Excutor<Account, Message> getAccountExcutor() {
		return accountExcutor;
	}
	
	public Excutor<ChannelHandlerContext, Message> getLoginExcutor() {
		return loginExcutor;
	}
}
