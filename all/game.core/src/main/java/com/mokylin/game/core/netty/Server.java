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

import com.mokylin.game.core.system.SignalHandler;
import com.mokylin.game.core.util.CommonUtil;

public abstract class Server extends Thread {
	protected static Logger logger = Logger.getLogger(Server.class);
	private int port;
	private EventLoopGroup accepterGroup;
	private EventLoopGroup clientGroup;

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
					ch.pipeline().addLast("handler", createHandlerAdapter());
				}
			})
			.option(ChannelOption.SO_BACKLOG, 128)
			.childOption(ChannelOption.SO_KEEPALIVE, true);

			ChannelFuture f = b.bind(port).sync();
			logger.error("端口监听成功");
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			logger.error(e, e);
			System.exit(-1);
		} finally {
			clientGroup.shutdownGracefully();
			accepterGroup.shutdownGracefully();
		}
	}

	@SuppressWarnings("restriction")
	private void initSignal() {
		sun.misc.Signal.handle(new sun.misc.Signal("INT"), new SignalHandler(this)); // kill
	}

	protected abstract GameHandlerAdapter createHandlerAdapter();

	public abstract void onStop();

	public void shutdown() {
		logger.error("服务器收到关闭信号");
		// 关闭所有链接
		clientGroup.shutdownGracefully();
		accepterGroup.shutdownGracefully();
		
		onStop();
		
		logger.error("需要等待" + (CommonUtil.time - (System.currentTimeMillis() / 1000)) + "秒之后才能重启,否则会出现ID重复");
		System.exit(0);
	}
}
