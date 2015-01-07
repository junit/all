package com.mokylin.game.core.cache.thread;

import com.mokylin.game.core.cache.ICallBack;

public class CacheData<K, V> {
	private K k;
	private ICallBack<V> cb;

	public CacheData(K k, ICallBack<V> cb) {
		this.k = k;
		this.cb = cb;
	}

	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}

	public ICallBack<V> getCb() {
		return cb;
	}

	public void setCb(ICallBack<V> cb) {
		this.cb = cb;
	}

}
