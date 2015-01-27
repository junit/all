package com.mokylin.game.core.util;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

public class ContextUtil {
	private static Logger logger = Logger.getLogger(ContextUtil.class);

	public static void close(ChannelHandlerContext ctx, String reason) {
		// TODO 暂时关闭
		return ;
//		logger.error("close context:" + reason);
//		ctx.close();
	}
}
