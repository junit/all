package com.mokylin.game.core.event;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class Excutor<OWNER, EVENT> {
	Disruptor<Event<OWNER, EVENT>> disruptor;

	@SuppressWarnings("unchecked")
	public Excutor(final String name, final int threadPriority, int buffSize) throws Exception {
		if (buffSize < 2 || (buffSize & (buffSize - 1)) != 0) {
			throw new Exception();
		}

		java.util.concurrent.Executor executor = Executors.newSingleThreadExecutor(new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r, name);
				thread.setPriority(threadPriority);
				return thread;
			}
		});
		disruptor = new Disruptor<>(Event::new, buffSize, executor);
		disruptor.handleEventsWith(new EventHandler<OWNER, EVENT>());
		disruptor.start();
	}

	public void excute(OWNER owner, EVENT event, GameEventHandler<OWNER, EVENT> handler) {
		RingBuffer<Event<OWNER, EVENT>> ringBuffer = disruptor.getRingBuffer();
		long next = ringBuffer.next();
		try {
			Event<OWNER, EVENT> t = ringBuffer.get(next);
			t.setOwner(owner);
			t.setGameEvent(event);
			t.setGameEventHandler(handler);
		} finally {
			ringBuffer.publish(next);
		}
	}
}
