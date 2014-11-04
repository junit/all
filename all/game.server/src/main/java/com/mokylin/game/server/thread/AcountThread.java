package com.mokylin.game.server.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AcountThread extends Thread {
	private AtomicInteger count = new AtomicInteger();
	public AtomicInteger getCount() {
		return count;
	}
}
