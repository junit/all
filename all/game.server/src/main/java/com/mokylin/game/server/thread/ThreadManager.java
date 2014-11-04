package com.mokylin.game.server.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.mokylin.game.core.util.CommonUtil;
import com.mokylin.game.server.config.Platform;
import com.mokylin.game.server.logic.account.Account;

public class ThreadManager {
	private AcountThread[] acccountThreads;
	private volatile int index;
	private volatile int min;
	private AtomicInteger count = new AtomicInteger();

	public void onLogin(Account account) {
		account.setThread(index);
		count.incrementAndGet();

		synchronized (this) {
			min = acccountThreads[index].getCount().getAndIncrement();
			while (min >= count.get() / acccountThreads.length){
				index = (index + 1) % acccountThreads.length;
				min = acccountThreads[index].getCount().get();
			}
		}
	}

	public void onLogout(Account account) {
		count.decrementAndGet();
		int tmpMin = acccountThreads[account.getThread()].getCount().getAndDecrement();
		synchronized (this) {
			if (tmpMin < min) {
				index = account.getThread();
				min = tmpMin;
			}
		}
	}

	public boolean init() {
		acccountThreads = new AcountThread[2 * Runtime.getRuntime().availableProcessors()];
		for (int i = 0; i < acccountThreads.length; ++i) {
			acccountThreads[i] = new AcountThread();
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(index).append("\t").append(min).append("\t").append(count.get());
		for (int i = 0; i < acccountThreads.length; ++i) {
			builder.append("\t").append(acccountThreads[i].getCount().get());
		}
		return builder.toString();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadManager m = new ThreadManager();
		m.init();
		
		Account account = new Account();
		account.setId(CommonUtil.uid(1, 1));
		account.setName("");
		account.setPlatform(Platform.ALL);
		account.setServer(1);
		account.setCreateTime(System.currentTimeMillis());
		account.setLoginTime(account.getCreateTime());
		
		int threadNum = Runtime.getRuntime().availableProcessors() * 2;
		ThreadPoolExecutor executor = new ThreadPoolExecutor(threadNum, threadNum, 1, TimeUnit.DAYS, new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < threadNum; ++i) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					int n = 1000;
					for (;;) {
						for (int i = 0; i < n; ++i) {
							m.onLogin(account);
						}
//						for (int i = 0; i < n; ++i) {
//							m.onLogout(account);
//						}
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
		}
		
		for (;;) {
			System.out.println(m);
			Thread.sleep(1000);
		}
	}
}
