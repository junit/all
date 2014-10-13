package com.mokylin.game.core.netty;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import org.apache.log4j.Logger;

import com.mokylin.game.core.netty.coder.Decoder;
import com.mokylin.game.core.netty.coder.Encoder;

public abstract class Client extends Thread {
	private static Logger logger = Logger.getLogger(Client.class);
	private String host;
	private int port;
	private static EventLoopGroup workerGroup = new NioEventLoopGroup();

	public Client(String name, String host, int port) {
		super(name);
		this.host = host;
		this.port = port;
	}

	protected abstract boolean init();

	@Override
	public void run() {
		if (!init()) {
			logger.error("初始化失败");
			System.exit(-1);
		}

		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup);
			b.channel(NioSocketChannel.class);
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 300000);
			b.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast("encoder", new Encoder());
					ch.pipeline().addLast("decoder", new Decoder());
					ch.pipeline().addLast("idle", new IdleStateHandler(1, 60, 60, TimeUnit.SECONDS));
					ch.pipeline().addLast("handler", createHandlerAdapter());
				}
			});

			ChannelFuture f = b.connect(host, port).sync();

			f.channel().closeFuture().sync();
		} catch (Exception e) {
			logger.error(e, e);
			System.exit(-1);
		} finally {
			workerGroup.shutdownGracefully();
		}

		System.exit(0);
	}

	protected abstract GameHandlerAdapter createHandlerAdapter();
}
