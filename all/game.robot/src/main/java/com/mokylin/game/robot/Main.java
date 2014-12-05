package com.mokylin.game.robot;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mokylin.game.core.netty.Client;
import com.mokylin.game.robot.message.MessageDispatcher;
import com.mokylin.game.robot.message.MessageFactoryImpl;

public class Main {
	public static final String PREFIX = "s1_";
	private static final String IP = "192.168.5.102";
	private static final int PORT = 5241;
	public static final int COUNT = 1;

	public static AtomicInteger count = new AtomicInteger();

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws InterruptedException {
		Injector injector = Guice.createInjector();
		int processors = Runtime.getRuntime().availableProcessors();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2 * processors, 2 * processors, 0, TimeUnit.DAYS, new LinkedBlockingQueue<>());
		Client client = new Client(IP, PORT, injector.getInstance(MessageDispatcher.class), injector.getInstance(MessageFactoryImpl.class));
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
