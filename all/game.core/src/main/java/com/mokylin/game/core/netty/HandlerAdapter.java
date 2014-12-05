package com.mokylin.game.core.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Message;

public abstract class HandlerAdapter extends ChannelInboundHandlerAdapter {
	protected static Logger logger = Logger.getLogger(HandlerAdapter.class);

	protected abstract void channelRead(ChannelHandlerContext ctx, Message msg);
	protected abstract void readIdle(ChannelHandlerContext ctx);
	protected abstract void writeIdle(ChannelHandlerContext ctx);
	protected abstract void allIdle(ChannelHandlerContext ctx);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object obj) {
		channelRead(ctx, (Message) obj);
	}
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent)evt;
			if (event == IdleStateEvent.READER_IDLE_STATE_EVENT) {
				readIdle(ctx);
			} else if (event == IdleStateEvent.WRITER_IDLE_STATE_EVENT) {
				writeIdle(ctx);
			} else if (event == IdleStateEvent.ALL_IDLE_STATE_EVENT) {
				allIdle(ctx);
			}
		}
	}
}
