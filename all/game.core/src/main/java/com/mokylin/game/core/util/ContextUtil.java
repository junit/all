package com.mokylin.game.core.util;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

public class ContextUtil {
	private static Logger logger = Logger.getLogger(ContextUtil.class);

	public static void close(ChannelHandlerContext ctx, String reason) {
		logger.error("close context:" + reason);
//		ctx.close();
		ctx.disconnect();
	}
}
