package com.mokylin.game.core.event;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class GameExcutor<T extends GameEvent> {
	Disruptor<T> disruptor;

	@SuppressWarnings("unchecked")
	public GameExcutor(final int threadPriority, EventFactory<T> factory, int buffSize, GameEventHandler<T> handler) throws Exception {
		if (buffSize < 2 || (buffSize & (buffSize - 1)) != 0) {
			throw new Exception();
		}

		Executor executor = Executors.newSingleThreadExecutor(new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setPriority(threadPriority);
				return thread;
			}
		});
		disruptor = new Disruptor<>(factory, buffSize, executor);
		disruptor.handleEventsWith(handler);
		disruptor.start();
	}

	public void excute(T event) {
		RingBuffer<T> ringBuffer = disruptor.getRingBuffer();
		long next = ringBuffer.next();
		try {
			T t = ringBuffer.get(ringBuffer.next());
			t.copy(event);
			// TODO init t
		} finally {
			ringBuffer.publish(next);
		}
	}
}
