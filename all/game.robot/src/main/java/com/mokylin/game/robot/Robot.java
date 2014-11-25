package com.mokylin.game.robot;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

public class Robot {
	private String account;
	private String check;
	private int platform;
	private int server;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public int getServer() {
		return server;
	}

	public void setServer(int server) {
		this.server = server;
	}

	private static final AttributeKey<Robot> key = AttributeKey.valueOf("robot");
	public static void bind(ChannelHandlerContext ctx, Robot robot) {
		ctx.attr(key).set(robot);
	}

	public static Robot getRobot(ChannelHandlerContext ctx) {
		return ctx.attr(key).get();
	}
}
