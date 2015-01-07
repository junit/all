package com.mokylin.game.core.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.mokylin.game.core.cache.thread.CacheThread;

/**
 *  缓存,适用于变动频繁的数据
 * @author shell
 */
public class Cache<K, V> extends Thread {
	private static Logger logger = Logger.getLogger(Cache.class);
	private long saveInterval; // 保存最少间隔
	private ConcurrentHashMap<K, V> map = new ConcurrentHashMap<>();
	private ILoader<K, V> loader;
	private CacheThread<K, V>[] threads;
	private volatile boolean exit = false;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Cache newCache(String threadName, ILoader loader, int max) {
		Cache cache = new Cache<>(threadName, loader, 30 * 60 * 1000L, max, Runtime.getRuntime().availableProcessors());
		
		cache.start();
		return cache;
	}

	@SuppressWarnings("unchecked")
	private Cache(String threadName, ILoader<K, V> loader, long saveInterval, int maxNum, int threadNum) {
		super(threadName);
		
		this.loader = loader;
		this.saveInterval = saveInterval;

		threads = new CacheThread[threadNum];
		for (int i = 0; i < threads.length; ++i) {
			threads[i] = new CacheThread<K, V>(threadName + "" + i, this, maxNum / threadNum + 1);
			threads[i].start();
		}
	}

	public void get(K k, ICallBack<V> cb) {
		threads[k.hashCode() % threads.length].add(k, cb);
	}
	
	public V get(K k) {
		V v = map.get(k);
		if (v == null) {
			throw new NullPointerException();
		}
		return v;
	}

	@Deprecated
	public V getDirect(K k) {
		V v = map.get(k);
		if (v != null) {
			return v;
		}

		v = loader.load(k);
		if (v == null) {
			throw new NullPointerException();
		}
		map.put(k, v);
		return v;
	}

	private void save(boolean ignoreInterrupt) {
		if (ignoreInterrupt) {
			logger.error(getName() + ":保存开始");
		}
		
		Iterator<Entry<K, V>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			if (!ignoreInterrupt && isInterrupted()) {
				exit = true;
				return ;
			}
			
			Entry<K, V> entry = it.next();
			
			try {
				loader.save(entry.getValue());
			} catch (Exception e) {
				loader.onSaveFailed(entry.getValue());
			}

			if (loader.canRemove(entry.getValue())) {
				logger.error("缓存中移除:" + entry.getValue());
				it.remove();
			}
		}
		
		if (ignoreInterrupt) {
			logger.error(getName() + ":保存完毕");
		}
	}
	
	@Override
	public void run() {
		long sleepMsec;
		long minMsec = 10;
		
		while (true) {
			long start = System.currentTimeMillis();

			save(false);
			
			sleepMsec = System.currentTimeMillis() - start;
			sleepMsec = saveInterval - sleepMsec;
			sleepMsec = sleepMsec <= 0 ? minMsec : sleepMsec;
			try {
				if (sleepMsec == minMsec) {
					logger.error(getName() + " busy");
				}
				Thread.sleep(sleepMsec);
			} catch (InterruptedException e) {
				save(true);
				exit = true;
			}
		}
	}

	public void onStop() {
		this.interrupt();
		while (!exit) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.error(e, e);
			}
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ArrayList<Long> list = new ArrayList<Long>();
		for (long i = 0; i < 10000000000L; ++i) {
			list.add(i);
		}
		
//		for (long i = 0; i < 10000000000L; ++i) {
//			if (list.get(i)) {
//				
//			}
//		}
		
		System.out.println(System.currentTimeMillis() - start);
	}
}
