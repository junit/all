package com.mokylin.game.core.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.message.MessageFactory;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.core.util.ZLibUtil;

public final class Decoder extends ByteToMessageDecoder {
	private final MessageFactory factory;
	private ByteBuf buf = Unpooled.buffer();
	private AtomicInteger num = new AtomicInteger(0);
	private static final int MAX_LENGTH = 1 * 1024 * 1024;
	
	public Decoder(MessageFactory factory) {
		this.factory = factory;
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		try {
			// 校验消息长度（4个字节）
			if (in.readableBytes() < Integer.SIZE / Byte.SIZE) {
				return;
			}

			// 标记读的位置
			in.markReaderIndex();

			// 获得信息长度
			int length = in.readInt(); // 1
			int read = length & 0x00FFFFFF;
			
			if (read > MAX_LENGTH) {
				ContextUtil.close(ctx, "啥子消息恁个长:" + read);
				return ;
			}

			if (in.readableBytes() < read) {
				in.resetReaderIndex();
				return;
			}

			int key = in.readInt(); // 2
			if (!check(key, read)) {
				ContextUtil.close(ctx, "消息号对不上");
				return ;
			}
			read -= 4;
			
			// 消息Id
			int msgId = in.readInt(); // 3
			read -= 4;
			// 消息
			Message message = factory.newInstance(msgId);
			if (message == null) {
				ContextUtil.close(ctx, "无此消息" + msgId);
				return;
			}

			// 是否压缩
			int zlib = (length & 0xFF000000) >> 24;
			if (zlib == 1) {
				// 读取指定长度的字节数
				byte[] bytes = new byte[read];
				in.readBytes(bytes);

				// 解压字节
				byte[] decompress = ZLibUtil.decompress(bytes);
				buf.writeBytes(decompress);
				message.read(buf);
			} else {
				message.read(in);
			}

			out.add(message);
		} finally {
			buf.clear();
		}
	}

	private boolean check(int recvKey, int length) {
		int key = num.getAndIncrement() ^ length;
		key = ((~key & (1 << 9)) | (key & ~(1 << 9)));
		return recvKey == key;
	}

	public static void main(String[] args) {
		System.out.println(Integer.SIZE);
		System.out.println(Byte.SIZE);
		System.out.println(Integer.SIZE / Byte.SIZE);
	}
}
