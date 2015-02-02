package com.mokylin.game.core.test;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	public static void main(String[] args) {
		AtomicInteger childIndex = new AtomicInteger();
		int[] children = {1, 2, 3, 4, 5, 6, 7, 8};
		
		for (int i = 0; i < 10; ++i) {
			System.err.println(children[Math.abs(childIndex.getAndIncrement() % children.length)]);
		}
	}
}
