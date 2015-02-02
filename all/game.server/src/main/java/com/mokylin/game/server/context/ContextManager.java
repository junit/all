package com.mokylin.game.server.context;

import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.ConcurrentHashMap;

import com.mokylin.game.core.message.Message;

public class ContextManager {
	private ConcurrentHashMap<Long, ChannelHandlerContext> contexts = new ConcurrentHashMap<>();

	public void write(ChannelHandlerContext ctx, Message msg) {
		ctx.writeAndFlush(msg);
	}
	
	public ConcurrentHashMap<Long, ChannelHandlerContext> getContexts() {
		return contexts;
	}
}
