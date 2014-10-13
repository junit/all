package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

import com.mokylin.game.core.netty.Client;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.robot.message.manager.MessageManager;

public class RobotClient extends Client {
	private static final AttributeKey<RobotClient> KEY = AttributeKey.valueOf("ROBOT");

	public RobotClient(String name, String host, int port) {
		super(name, host, port);
	}

	@Override
	protected boolean init() {
		MessageManager messageManager = new MessageManager();
		messageManager.init();
		return true;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher(this);
	}

	public static void set(ChannelHandlerContext ctx, RobotClient robot) {
		ctx.attr(KEY).set(robot);
	}

	public static RobotClient get(ChannelHandlerContext ctx) {
		return ctx.attr(KEY).get();
	}

}
