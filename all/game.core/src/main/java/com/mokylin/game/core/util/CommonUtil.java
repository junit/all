package com.mokylin.game.core.util;

import java.util.HashSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

	public static void main(String[] args) throws InterruptedException {
//		final ConcurrentHashMap<Long, Long> tmp = new ConcurrentHashMap<>();
//		int threadNum = 8;
//		int ccc = 100000;
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(threadNum, threadNum, 1, TimeUnit.DAYS, new LinkedBlockingQueue<Runnable>());
//		AtomicInteger count = new AtomicInteger();
//		for (int i = 0; i < threadNum; ++i) {
//			executor.execute(new Runnable() {
//				@Override
//				public void run() {
//					for (int xxx = 0; xxx < ccc; ++xxx) {
//						count.incrementAndGet();
//						long uid = uid(xxx, xxx);
//						if (tmp.containsKey(uid)) {
//							System.err.println(uid);
//						} else {
//							tmp.put(uid, uid);
//						}
//					}
//				}
//			});
//		}
//
//		for (;;) {
//			if (count.get() >= threadNum * ccc) {
//				break;
//			}
//			Thread.sleep(10);
//		}
//		executor.shutdown();
//		System.out.println(tmp.size());
//		System.out.println(System.currentTimeMillis() / 1000 - time);
		
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 10; ++i) {
			set.add(i);
		}
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.DAYS, new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 10; ++i) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; ++i) {
						try {
						set.contains(i);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
	}
}
