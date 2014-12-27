package com.mokylin.game.core.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.message.bean.Message;

public abstract class GameHandlerAdapter extends ChannelInboundHandlerAdapter {
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
}
