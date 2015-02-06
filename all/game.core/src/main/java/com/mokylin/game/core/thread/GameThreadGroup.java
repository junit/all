package com.mokylin.game.core.thread;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Command;

public class GameThreadGroup {
	private ConcurrentHashMap<GameObject, GameThread> excutor2thread = new ConcurrentHashMap<>();
	private volatile GameThread[] threads;
	private volatile GameThread lazyThread;
	private volatile int count = 0;
	private volatile int index = 0;
	private Logger logger;
	
	public void add(GameObject excutor, Command command) throws Exception {
		GameThread thread = excutor2thread.get(excutor);
		if (thread == null) {
			add(excutor);
			thread = excutor2thread.get(excutor); // 再错就不管了
		}
		thread.add(command);
	}

	public synchronized void add(GameObject obj) {
		if (excutor2thread.containsKey(obj)) {
			return ;
		}
		excutor2thread.put(obj, lazyThread);
		lazyThread.getObjects().put(obj, 1);
		
		++count;
		while (lazyThread.getObjects().size() > count / threads.length) {
			lazyThread = next();
		}
	}

	private GameThread next() {
		index = (index + 1) % threads.length;
		return threads[index];
	}

	public synchronized void remove(GameObject obj) {
		GameThread thread = excutor2thread.remove(obj);
		if (thread == null) {
			return ;
		}
		thread.getObjects().remove(obj);
		
		--count;
		if (thread.getObjects().size() < lazyThread.getObjects().size()) {
			lazyThread = thread;
		}
	}

	public GameThreadGroup(String name) {
		this(name, 2 * Runtime.getRuntime().availableProcessors() + 1);
	}

	public GameThreadGroup(String name, int threadNum) {
		logger = Logger.getLogger(name);
		threads = new GameThread[threadNum];
		for (int i = 0; i < threads.length; ++i) {
			threads[i] = new GameThread(name + "-" + i, logger);
			threads[i].start();
		}
		lazyThread = next();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(index).append("\t").append(lazyThread.getObjects().size()).append("\t").append(count);
		for (int i = 0; i < threads.length; ++i) {
			builder.append("\t").append(threads[i].getObjects().size());
		}
		return builder.toString();
	}
	
	public synchronized boolean check() {
		int total = 0;
		for (int i = 0; i < threads.length; ++i) {
			if (threads[i].getObjects().size() < lazyThread.getObjects().size()) {
				System.out.println("not very small:" + threads[i].getObjects().size() + " > " + lazyThread.getObjects().size());
				return false;
			}
			total += threads[i].getObjects().size();
		}
		return total == count;
	}
}

