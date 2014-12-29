package com.mokylin.game.robot;

import org.apache.log4j.Logger;

public class Main {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		for (int i = 0; i < 300; ++i) {
				RobotClient client = new RobotClient("robot_" + i, "127.0.0.1", 5241);
				client.start();
		}
	}

}
