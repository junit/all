package com.mokylin.game.robot;

import org.apache.log4j.Logger;

public class Main {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		for (int i = 0; i < 5; ++i) {
			RobotClient client = new RobotClient("s1_" + i, "192.168.5.102", 7777);
			client.start();
		}
	}

}
