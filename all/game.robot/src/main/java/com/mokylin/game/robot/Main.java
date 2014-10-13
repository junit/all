package com.mokylin.game.robot;

import org.apache.log4j.Logger;

import com.mokylin.game.robot.message.manager.MessageManager;

public class Main {
	public static final int COUNT = 10000;
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		MessageManager messageManager = new MessageManager();
		messageManager.init();
		
		for (int i = 0; i < COUNT; ++i) {
			RobotClient client = new RobotClient("robot_" + i, "183.60.122.232", 7777);
			client.start();
		}
	}

}
