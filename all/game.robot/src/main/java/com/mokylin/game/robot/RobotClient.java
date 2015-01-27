package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

import com.mokylin.game.core.netty.Client;
import com.mokylin.game.core.netty.GameHandlerAdapter;


public class RobotClient extends Client {
	private static final AttributeKey<RobotClient> key = AttributeKey.valueOf("client");
	
	public RobotClient(String host, int port) {
		super(host, port);
	}

	@Override
	protected boolean init() {
		return true;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher();
	}

	public static void set(ChannelHandlerContext ctx, RobotClient robot) {
		ctx.attr(key).set(robot);
	}

	public static RobotClient get(ChannelHandlerContext ctx) {
		return ctx.attr(key).get();
	}
}
