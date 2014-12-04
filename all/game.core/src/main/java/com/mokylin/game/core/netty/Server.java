package com.mokylin.game.core.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public final class Server extends Thread {
	protected static Logger logger = Logger.getLogger(Server.class);
	private int port;
	private EventLoopGroup accepterGroup;
	private EventLoopGroup clientGroup;
	private HandlerAdapter handlerAdapter;

	public Server(String name, int port, HandlerAdapter handlerAdapter) {
		super(name);
		this.port = port;
		this.handlerAdapter = handlerAdapter;
	}

	@Override
	public void run() {
		accepterGroup = new NioEventLoopGroup(1);
		clientGroup = new NioEventLoopGroup(2 * Runtime.getRuntime().availableProcessors());
		
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(accepterGroup, clientGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast("encoder", new Encoder());
					ch.pipeline().addLast("decoder", new Decoder());
					ch.pipeline().addLast("idle", new IdleStateHandler(60, 60, 60, TimeUnit.SECONDS));
					ch.pipeline().addLast("handler", handlerAdapter);
				}
			})
			.option(ChannelOption.SO_BACKLOG, 128)
			.childOption(ChannelOption.SO_KEEPALIVE, true)
			.childOption(ChannelOption.TCP_NODELAY, true)
			.childOption(ChannelOption.SO_RCVBUF, 128 * 1024)
			.childOption(ChannelOption.SO_SNDBUF, 128 * 1024);

			ChannelFuture f = b.bind(port).sync();
			logger.error("端口" + port + "监听成功");
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			logger.error(e, e);
			System.exit(-1);
		}
	}

	public void shutdown() {
		clientGroup.shutdownGracefully();
		accepterGroup.shutdownGracefully();
	}
}
