package com.mokylin.game.core.common;

public class IdFactory {
	private int seed = 0;
	public long time = System.currentTimeMillis() / 1000L;

	/**
	 * 伪唯一id
	 * 
	 * @param platform
	 * @param server
	 * @return
	 */
	public synchronized long uid(int platform, int server) {
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
}
