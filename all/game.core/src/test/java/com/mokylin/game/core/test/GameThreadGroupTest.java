package com.mokylin.game.core.test;

import java.util.concurrent.ThreadLocalRandom;

import junit.framework.TestCase;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.junit.Before;
import org.junit.Test;

import com.mokylin.game.core.thread.GameObject;
import com.mokylin.game.core.thread.GameThreadGroup;

class TestGameObject extends GameObject {
}

public class GameThreadGroupTest extends TestCase {
	private volatile GameThreadGroup m = new GameThreadGroup("test");
	private volatile TestGameObject[] objs;
	private volatile int max = 100000;
	private volatile int n = max / 10;
	private final int THREAD_NUM = 100;

	class TestThread extends TestRunnable {
		@Override
		public void runTest() throws Throwable {
			int startIndex = ThreadLocalRandom.current().nextInt(max);
			for (int i = 0; i < n; ++i) {
				int index = (startIndex + i) % max;
				m.add(objs[index]);
			}
			startIndex = ThreadLocalRandom.current().nextInt(max);
			for (int i = 0; i < n; ++i) {
				int index = (startIndex + i) % max;
				m.remove(objs[index]);
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Before
	public void setUp() throws Exception {
		objs = new TestGameObject[max];
		for (int i = 0; i < max; ++i) {
			objs[i] = new TestGameObject();
		}
	}

	@Test
	public void testAction() throws Throwable {
		TestRunnable[] test = new TestRunnable[THREAD_NUM];
		long start = System.currentTimeMillis();
		for (int i = 0; i < test.length; i++) {
			test[i] = new TestThread();
		}
		// 生成测试线程运行器
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(test);
		// 运行测试线程
		mttr.runTestRunnables();
		long used = System.currentTimeMillis() - start;
		System.out.printf("%s 调用花费 %s ms.\n", THREAD_NUM, used);
		System.out.println(m.toString());
		assertEquals(true, m.check());
	}
}
