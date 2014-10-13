package com.mokylin.game.core.netty;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.message.bean.Message;

public abstract class GameHandlerAdapter extends IdleStateHandler {
	public GameHandlerAdapter() {
		super(5, 5, 5, TimeUnit.MILLISECONDS);
	}

	protected static Logger logger = Logger.getLogger(GameHandlerAdapter.class);

	protected abstract void onRecvMsg(com.mokylin.game.core.message.bean.Handler handler);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object obj) { // (2)
		if (!(obj instanceof Message)) {
			return;
		}
		Message msg = (Message) obj;

		com.mokylin.game.core.message.bean.Handler handler = null;
		try {
			handler = MessagePool.getInstance().createHandler(msg.getId());
		} catch (Exception e) {
			ctx.close();
			logger.error(e, e);
			return;
		}

		if (handler == null) {
			ctx.close();
			return;
		}

		handler.setMessage(msg);
		handler.setContext(ctx);

		onRecvMsg(handler);
	}
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent)evt;
			logger.error(event);
		}
	}
}
