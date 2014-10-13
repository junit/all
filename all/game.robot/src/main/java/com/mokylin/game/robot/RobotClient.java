package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

import com.mokylin.game.core.netty.Client;
import com.mokylin.game.core.netty.GameHandlerAdapter;
import com.mokylin.game.robot.logic.login.message.ResPlayerDetailMessage;

public class RobotClient extends Client {
	private static final AttributeKey<RobotClient> key = AttributeKey.valueOf("client");
	
	private ResPlayerDetailMessage detailMessage;

	public RobotClient(String name, String host, int port) {
		super(name, host, port);
	}

	@Override
	protected boolean init() {
		return true;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher(this);
	}

	public static void set(ChannelHandlerContext ctx, RobotClient robot) {
		ctx.attr(key).set(robot);
	}

	public static RobotClient get(ChannelHandlerContext ctx) {
		return ctx.attr(key).get();
	}

	public ResPlayerDetailMessage getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(ResPlayerDetailMessage detailMessage) {
		this.detailMessage = detailMessage;
	}

}
