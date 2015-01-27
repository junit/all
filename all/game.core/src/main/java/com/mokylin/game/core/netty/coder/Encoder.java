package com.mokylin.game.core.netty.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.bean.Message;

public final class Encoder extends MessageToByteEncoder<Message> {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(Encoder.class);
	private AtomicInteger sendedMsgNum = new AtomicInteger(0);
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
		 /* 
		  * 长度 ，校验码，消息id，发送时间（占位但是已经没有使用了）
		  */
		// 占位
		out.writeInt(0);
		out.writeInt(0);
		out.writeInt(0);
		out.writeInt(0);

		//消息体部分
		msg.write(out);

		//消息长度
		int length = out.readableBytes() - Integer.SIZE / Byte.SIZE;
		
		//校验码
		int key = sendedMsgNum.getAndIncrement() ^ length;
		key = ((~key & (1 << 9)) | (key & ~(1 << 9)));
		
		//长度
		out.setInt(0, length);
		//校验码
		out.setInt(4, key);
		//消息id
		out.setInt(8, msg.getId());
		//发送时间
		out.setInt(12, 0);
		
		ctx.flush();
	}
}
