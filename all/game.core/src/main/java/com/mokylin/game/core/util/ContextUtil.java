package com.mokylin.game.core.util;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Message;

public class ContextUtil {
	private static Logger logger = Logger.getLogger(ContextUtil.class);

	public static void close(ChannelHandlerContext ctx, String reason) {
		logger.error("close context:" + reason);
		ctx.close();
	}
	
	public static void write(ChannelHandlerContext ctx, Message msg) {
		ctx.writeAndFlush(msg);
	}
}
