package com.mokylin.game.core.netty.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.AttributeKey;

import java.util.List;

import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.message.bean.Message;
import com.mokylin.game.core.util.ContextUtil;

public class Decoder extends ByteToMessageDecoder {
	private static final AttributeKey<Object> MESSAGE_TIME = AttributeKey.valueOf("MESSAGE_TIME");
	private static final AttributeKey<Object> MESSAGE_COUNT = AttributeKey.valueOf("MESSAGE_COUNT");
	private static final int MESSAGE_COUNT_NUM = 30;
	private static final int MESSAGE_COUNT_MSEC = 1000;

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if (in.readableBytes() < (Integer.SIZE / Byte.SIZE)) {
			return;
		}
		in.markReaderIndex();

		int length = in.readInt();
		if (length < 0) {
			ContextUtil.close(ctx, "消息头长度错误:" + length);;
			return;
		}

		if (length > in.readableBytes()) { // wait until bytes enough
			in.resetReaderIndex();
			return;
		}

		if (!rateCheck(ctx, MESSAGE_COUNT_NUM, MESSAGE_COUNT_MSEC)) {
			ContextUtil.close(ctx, "发送频率过高");;
			return;
		}

		int messageId = in.readInt();

		Message message = MessagePool.getInstance().createMessage(messageId);
		if (message == null) {
			ContextUtil.close(ctx, "找不到消息:" + messageId);;
			return;
		}

		if (!message.read(in)) {
			ContextUtil.close(ctx, "读取消息错误:" + messageId);;
			return;
		}

		out.add(message);
	}

	private boolean rateCheck(ChannelHandlerContext ctx, int maxNum, int perMsec) {
		
		Object object = ctx.attr(MESSAGE_TIME).get();
		if (object == null) {
			object = System.currentTimeMillis();
			ctx.attr(MESSAGE_TIME).set(object);
			ctx.attr(MESSAGE_COUNT).set(0);
			return true;
		}

		long time = (Long) object;
		long nowTime = System.currentTimeMillis();
		if (time - nowTime > perMsec) {
			ctx.attr(MESSAGE_TIME).set(nowTime);
			ctx.attr(MESSAGE_COUNT).set(0);
			return true;
		}

		int count = (Integer) ctx.attr(MESSAGE_COUNT).get();
		if (count > maxNum) {
			return false;
		}
		ctx.attr(MESSAGE_COUNT).set(count + 1);
		return true;
	}

	public static void main(String[] args) {
		System.out.println(Integer.SIZE);
		System.out.println(Byte.SIZE);
		System.out.println(Integer.SIZE / Byte.SIZE);
	}
}
