package com.mokylin.game.robot;

import com.mokylin.game.core.netty.Client;
import com.mokylin.game.core.netty.GameHandlerAdapter;


public class RobotClient extends Client {
//	private String account;
//	private String check;
//	private int platform;
//	private int server;
	public RobotClient(String host, int port/*, String account, String check, int platform, int server*/) {
		super(host, port);
//		this.account = account;
//		this.check = check;
//		this.platform = platform;
//		this.server = server;
	}

	@Override
	protected boolean init() {
		return true;
	}

	@Override
	protected GameHandlerAdapter createHandlerAdapter() {
		return new MessageDispatcher(this);
	}

//	public String getAccount() {
//		return account;
//	}
//
//	public void setAccount(String account) {
//		this.account = account;
//	}
//
//	public String getCheck() {
//		return check;
//	}
//
//	public void setCheck(String check) {
//		this.check = check;
//	}
//
//	public int getPlatform() {
//		return platform;
//	}
//
//	public void setPlatform(int platform) {
//		this.platform = platform;
//	}
//
//	public int getServer() {
//		return server;
//	}
//
//	public void setServer(int server) {
//		this.server = server;
//	}
	
}
