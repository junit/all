package com.mokylin.game.core.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public abstract class Client {
	private static Logger logger = Logger.getLogger(Client.class);
	private String host;
	private int port;
	private EventLoopGroup workerGroup = new NioEventLoopGroup();
	private Bootstrap bootstrap;

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
		
		workerGroup = new NioEventLoopGroup();
		bootstrap = new Bootstrap();
		bootstrap.group(workerGroup);
		bootstrap.channel(NioSocketChannel.class);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000);
		bootstrap.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			public void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast("encoder", new Encoder());
				ch.pipeline().addLast("decoder", new Decoder());
				ch.pipeline().addLast("idle", new IdleStateHandler(1, 60, 60, TimeUnit.SECONDS));
				ch.pipeline().addLast("handler", createHandlerAdapter());
			}
		});
	}

	protected abstract boolean init();

	public void connect() {
		if (!init()) {
			logger.error("初始化失败");
			System.exit(-1);
		}

		try {
			ChannelFuture f = bootstrap.connect(host, port);
			f.awaitUninterruptibly();
		} catch (Exception e) {
			logger.error(e, e);
			System.exit(-1);
		} finally {
//			workerGroup.shutdownGracefully();
		}

//		System.exit(0);
	}

	protected abstract GameHandlerAdapter createHandlerAdapter();
}
