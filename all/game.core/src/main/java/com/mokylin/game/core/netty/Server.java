package com.mokylin.game.core.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.apache.log4j.Logger;

import com.mokylin.game.core.netty.coder.Decoder;
import com.mokylin.game.core.netty.coder.Encoder;

public abstract class Server extends Thread {
	protected static Logger logger = Logger.getLogger(Server.class);
	private int port;
	public Server(String name, int port) {
		super(name);
		this.port = port;
	}

	protected abstract boolean init();

	
	@Override
	public void run() {
		if (!init()) {
			logger.error("初始化失败");
			System.exit(-1);
		}

		EventLoopGroup accepterGroup = new NioEventLoopGroup();
		EventLoopGroup clientGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(accepterGroup, clientGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new Encoder());
					ch.pipeline().addLast(new Decoder());
					ch.pipeline().addLast(createHandlerAdapter());
				}
			}).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);

			ChannelFuture f = b.bind(port).sync();

			f.channel().closeFuture().sync();
		} catch (Exception e) {
			logger.error(e, e);
			System.exit(-1);
		} finally {
			clientGroup.shutdownGracefully();
			accepterGroup.shutdownGracefully();
		}
		System.exit(0);
	}
	
	protected abstract GameHandlerAdapter createHandlerAdapter();
}
