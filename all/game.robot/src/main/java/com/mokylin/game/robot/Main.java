package com.mokylin.game.robot;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.mokylin.game.robot.message.MessageManager;

public class Main {
	public static final String PREFIX = "s3_";
	// private static final String IP = "183.60.122.232";
	private static final String IP = "183.60.122.232";
	private static final int PORT = 7777;
	public static final int COUNT = 20000;

	public static AtomicInteger count = new AtomicInteger();

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws InterruptedException {
		MessageManager manager = new MessageManager();
		manager.init();

		int processors = Runtime.getRuntime().availableProcessors();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2 * processors, 2 * processors, 0, TimeUnit.DAYS, new LinkedBlockingQueue<>());
		RobotClient client = new RobotClient(IP, PORT);
		for (int i = 0; i < COUNT; ++i) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					client.connect();
				}
			});
		}
	}
}
