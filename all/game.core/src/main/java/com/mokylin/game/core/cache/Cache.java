package com.mokylin.game.core.cache;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.mokylin.game.core.cache.thread.CacheThread;

public class Cache<K, V> extends Thread {
	private static Logger logger = Logger.getLogger(Cache.class);
	private long saveInterval; // 保存最少间隔
	private ConcurrentHashMap<K, V> map = new ConcurrentHashMap<>();
	private ILoader<K, V> loader;
	private IRemover<V> remover;
	private CacheThread<K, V>[] threads;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Cache build(ILoader loader, IRemover remover, long saveInterval, int saveMax, int threadNum, String threadName) {
		Cache cache = new Cache<>(loader, remover, saveInterval, saveMax, threadNum, threadName);
		cache.start();
		return cache;
	}

	@SuppressWarnings("unchecked")
	private Cache(ILoader<K, V> loader, IRemover<V> remover, long saveInterval, int saveMax, int threadNum, String threadName) {
		super(threadName);
		
		this.loader = loader;
		this.remover = remover;
		this.saveInterval = saveInterval;

		threads = new CacheThread[threadNum];
		for (int i = 0; i < threads.length; ++i) {
			threads[i] = new CacheThread<K, V>(threadName + "" + i, this, saveMax / threadNum + 1);
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

	@Override
	public void run() {
		while (true) {
			long start = System.currentTimeMillis();

			Iterator<Entry<K, V>> it = map.entrySet().iterator();
			
			while (it.hasNext()) {
				Entry<K, V> entry = it.next();
				
				try {
					loader.save(entry.getValue());
				} catch (Exception e) {
					loader.onSaveFailed(entry.getValue());
				}

				if (remover.canRemove(entry.getValue())) {
					logger.error("缓存中移除:" + entry.getValue());
					it.remove();
				}
			}

			long sleepMsec = System.currentTimeMillis() - start;
			sleepMsec = saveInterval - sleepMsec;
			sleepMsec = sleepMsec <= 0 ? 10 : sleepMsec;
			try {
				Thread.sleep(sleepMsec);
			} catch (InterruptedException e) {
				logger.error(e, e);
			}
		}
	}
}
