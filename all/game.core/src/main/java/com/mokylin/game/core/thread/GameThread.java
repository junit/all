package com.mokylin.game.core.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Command;

public class GameThread extends Thread {
	private final static int MOD = 0x3ff;

	private Logger logger;
	private ConcurrentHashMap<GameObject, Object> objects = new ConcurrentHashMap<>();
	private LinkedBlockingQueue<Command> commands;
	private int count = 0;

	public GameThread(String name, Logger logger) {
		super(name);
		this.logger = logger;
		commands = new LinkedBlockingQueue<>();
	}

	public ConcurrentHashMap<GameObject, Object> getObjects() {
		return objects;
	}

	public void add(Command command) throws Exception {
		commands.put(command);
	}

	@Override
	public void run() {

		for (;;) {
			try {
				Command command = commands.take();
				long start = System.currentTimeMillis();

				try {
					command.exec();
				} catch (Exception e) {
					logger.error(e, e);
				}

				// 时间开销统计
				long interval = System.currentTimeMillis() - start;
				if (interval > command.timeOutMs()) {
					logger.error(String.format("garbage:%s,%s,%d", getName(), command.getClass().getSimpleName(), interval));
				}

				// 消息数量统计
				count = (count + 1) & MOD;
				if (count == 0) {
					logger.error(String.format("remain:%d", commands.size()));
				}
			} catch (InterruptedException e) {
				logger.error(e, e);
			}
		}
	}
}
