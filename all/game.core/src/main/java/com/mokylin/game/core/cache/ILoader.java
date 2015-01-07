package com.mokylin.game.core.cache;

public interface ILoader<K, V> {
	public V load(K k);
	public void save(V v);
	public void onSaveFailed(V v);
}
