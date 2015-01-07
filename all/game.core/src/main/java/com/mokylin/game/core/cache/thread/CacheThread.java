package com.mokylin.game.core.cache.thread;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.mokylin.game.core.cache.Cache;
import com.mokylin.game.core.cache.ICallBack;

public class CacheThread<K, V> extends Thread {
	private static Logger logger = Logger.getLogger(CacheThread.class);
	private Cache<K, V> cache;
	private LinkedBlockingQueue<CacheData<K, V>> list;
	
	public CacheThread(String name, Cache<K, V> cache, int max) {
		super(name);
		this.cache = cache;
		list = new LinkedBlockingQueue<>(max);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		 while (true) {
			 try {
				CacheData<K, V> data = list.take();
				V v = cache.getDirect(data.getK());
				data.getCb().exec(v);
			} catch (InterruptedException e) {
				logger.error(e, e);
			}
		 }
	}

	public void add(K k, ICallBack<V> cb) {
		try {
			list.put(new CacheData<K, V>(k, cb));
		} catch (InterruptedException e) {
			logger.error(e, e);
		}
	}
}
