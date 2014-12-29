package com.mokylin.game.robot.logic.login.handler;

import java.util.concurrent.atomic.AtomicInteger;

import com.mokylin.game.core.message.bean.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.robot.logic.login.message.ResLoginResultMessage;

public class ResLoginResultHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResLoginResultHandler.class);
	private static AtomicInteger count = new AtomicInteger();
    @Override
    public void exec() {
    	try {
    		ResLoginResultMessage msg = (ResLoginResultMessage)this.getMessage();
    		logger.error("登录成功:" + count.incrementAndGet());
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
