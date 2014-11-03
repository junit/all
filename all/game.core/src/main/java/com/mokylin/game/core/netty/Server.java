package com.mokylin.game.core.netty;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import org.apache.log4j.Logger;

import com.mokylin.game.core.system.SignalHandler;

public abstract class Server extends Thread {
	protected static Logger logger = Logger.getLogger(Server.class);
	private int port;
	private EventLoopGroup bossGroup;
	private EventLoopGroup workerGroup;

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

		initSignal();

		bossGroup = new NioEventLoopGroup();
		workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast("encoder", new Encoder());
					ch.pipeline().addLast("decoder", new Decoder());
					ch.pipeline().addLast("idle", new IdleStateHandler(60, 60, 60, TimeUnit.SECONDS));
					ch.pipeline().addLast("handler", createHandlerAdapter());
				}
			}).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);

			ChannelFuture f = b.bind(port).sync();

			f.channel().closeFuture().sync();
		} catch (Exception e) {
			logger.error(e, e);
			System.exit(-1);
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	@SuppressWarnings("restriction")
	private void initSignal() {
		sun.misc.Signal.handle(new sun.misc.Signal("INT"), new SignalHandler(this)); // kill
	}

	protected abstract GameHandlerAdapter createHandlerAdapter();

	public abstract void onStop();

	public void stopManual() {
		logger.error("服务器收到关闭信号");
		// 关闭所有链接
		workerGroup.shutdownGracefully();
		bossGroup.shutdownGracefully();
		
		onStop();
		
		System.exit(0);
	}
}
