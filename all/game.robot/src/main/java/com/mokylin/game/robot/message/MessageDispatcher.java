package com.mokylin.game.robot.message;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.netty.HandlerAdapter;
import com.mokylin.game.robot.message.impl.CtxMessage;

@Sharable
public class MessageDispatcher extends HandlerAdapter {
	private static Logger logger = Logger.getLogger(MessageDispatcher.class);
	private final MessageHandlerGroup handlerGroup;
	
	@Inject
	public MessageDispatcher(MessageHandlerGroup handlerGroup) {
		this.handlerGroup = handlerGroup;
	}

	@Override
	protected void channelRead(ChannelHandlerContext ctx, Message msg) {
		if (msg instanceof CtxMessage) {
			CtxMessage ret = new CtxMessage();
			ctx.writeAndFlush(ret);
		}
	}
	
	private static AtomicInteger count = new AtomicInteger(0);

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		CtxMessage ret = new CtxMessage();
		ctx.writeAndFlush(ret);
		logger.error("当前连接数量:" + count.incrementAndGet());
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.error("当前连接数量:" + count.decrementAndGet());
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error(cause, cause);
	}

	@Override
	protected void readIdle(ChannelHandlerContext ctx) {
		// do nothing
	}

	@Override
	protected void writeIdle(ChannelHandlerContext ctx) {
		// do noting
	}

	@Override
	protected void allIdle(ChannelHandlerContext ctx) {
		// do nothing
	}
}
