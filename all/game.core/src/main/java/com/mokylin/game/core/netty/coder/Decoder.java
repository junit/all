package com.mokylin.game.core.netty.coder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import com.mokylin.game.core.message.MessagePool;
import com.mokylin.game.core.message.bean.Message;
import com.mokylin.game.core.util.ContextUtil;
import com.mokylin.game.core.util.ZLibUtil;

public class Decoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// 校验消息长度（4个字节）
		if (in.readableBytes() < Integer.SIZE / Byte.SIZE) {
			return;
		}

		// 标记读的位置
		in.markReaderIndex();

		// 获得信息长度
		int dataLength = in.readInt();
		// 是否压缩
		int zlib = (dataLength & 0xFF000000) >> 24;
		dataLength = dataLength & 0x00FFFFFF;

		if (in.readableBytes() < dataLength) {
			in.resetReaderIndex();
			return;
		}

		// 消息Id
		int msgId = in.readInt();
		// 消息
		Message message = MessagePool.getInstance().createMessage(msgId);
		
		if (message == null) {
			ContextUtil.close(ctx, "无此消息" + msgId);
			return ;
		}

		if (zlib == 1) {
			// 读取指定长度的字节数
			byte[] msgBodyBytes = new byte[dataLength - 4];
			in.readBytes(msgBodyBytes);

			// 解压字节
			msgBodyBytes = ZLibUtil.decompress(msgBodyBytes);

			ByteBuf msgBuffer = Unpooled.buffer(msgBodyBytes.length);
			msgBuffer.writeBytes(msgBodyBytes);
			// 读取消息
			message.read(msgBuffer);
		} else {
			// 读取消息
			message.read(in);
		}

		out.add(message);
	}

	public static void main(String[] args) {
		System.out.println(Integer.SIZE);
		System.out.println(Byte.SIZE);
		System.out.println(Integer.SIZE / Byte.SIZE);
	}
}
