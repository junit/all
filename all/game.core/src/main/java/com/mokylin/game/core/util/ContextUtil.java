package com.mokylin.game.core.util;

import org.apache.log4j.Logger;

import io.netty.channel.ChannelHandlerContext;

public class ContextUtil {
	private static Logger logger = Logger.getLogger(ContextUtil.class);
	
	public static void close(ChannelHandlerContext ctx, String reason) {
		logger.error("close context:" + reason);
		ctx.close();
	}
}
