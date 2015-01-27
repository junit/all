package com.mokylin.game.robot.logic.login.handler;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.bean.Handler;
import com.mokylin.game.robot.Main;
import com.mokylin.game.robot.logic.login.message.ResLoginResultMessage;

public class ResLoginResultHandler extends Handler {
	private static Logger logger = Logger.getLogger(ResLoginResultHandler.class);

	public static AtomicInteger count = new AtomicInteger();
	public static long start;
	
	@Override
	public void exec() {
		try {
			ResLoginResultMessage msg = (ResLoginResultMessage) this.getMessage();
			
//			logger.error("登录成功玩家:" + count.getAndIncrement());
			if (count.incrementAndGet() % 100 == 0) {
				logger.error("登录成功玩家:" + count.get());
			}
			if (count.get() == 1) {
				start = System.currentTimeMillis();
			} else if (count.get() == Main.COUNT) {
				logger.error("登录总耗时:" + (System.currentTimeMillis() - start));
			}
			// TODO
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
}
