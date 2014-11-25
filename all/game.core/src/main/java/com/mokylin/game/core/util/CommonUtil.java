package com.mokylin.game.core.util;

import java.util.concurrent.ThreadLocalRandom;

public class CommonUtil {
	private static int seed = 0;
	public static long time = System.currentTimeMillis() / 1000L;

	/**
	 * 仅仅用于生成玩家id
	 * 
	 * @param platform
	 * @param server
	 * @return
	 */
	public static synchronized long uid(int platform, int server) {
		long now = System.currentTimeMillis() / 1000L;
		if (now > time) {
			time = now;
		}
		++seed;
		if (seed >= 0xff) {
			seed &= 0xff;
			++time;
		}
		return ((long) platform & 0xff) << 56 | ((long) server & 0xffff) << 40 | (time & 0xffffffff) << 8 | seed & 0xff;
	}
	
	public static int random(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; ++i) {
			System.err.println(random(0, 1));
		}
	}
}
