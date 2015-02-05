package com.mokylin.game.core.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Message;
import com.mokylin.game.core.util.ZLibUtil;

public final class Encoder extends MessageToByteEncoder<Message> {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(Encoder.class);
	private AtomicInteger num = new AtomicInteger(0);
	private ByteBuf buf = Unpooled.buffer();

	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
		try {
			out.writeInt(0); // 1
			out.writeInt(0); // 2
			out.writeInt(0); // 3

			int zlib = 0;
			msg.write(buf);
			if (buf.readableBytes() > 512) {
				byte[] compress = ZLibUtil.compress(buf.array());
				out.writeBytes(compress);
				zlib = 0x1 << 24;
			} else {
				msg.write(out);
			}
			int key = num.getAndIncrement() ^ (out.readableBytes() - 4);
			key = ((~key & (1 << 9)) | (key & ~(1 << 9)));

			out.setInt(0, zlib | (out.readableBytes() - 4));
			out.setInt(4, key); // 2
			out.setInt(8, msg.getId()); // 3
			ctx.flush();
		} finally {
			buf.clear();
		}
	}
}
