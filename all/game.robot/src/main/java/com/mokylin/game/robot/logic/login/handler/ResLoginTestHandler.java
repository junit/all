package com.mokylin.game.robot.logic.login.handler;

import java.util.concurrent.atomic.AtomicInteger;

import com.mokylin.game.core.message.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.robot.logic.login.message.ResLoginTestMessage;

public class ResLoginTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResLoginTestHandler.class);
	private static AtomicInteger all = new AtomicInteger();
	private static AtomicInteger lazy = new AtomicInteger();
    @Override
    public void exec() {
    	try {
    		ResLoginTestMessage msg = (ResLoginTestMessage)this.getMessage();
    		all.incrementAndGet();
    		if ((System.currentTimeMillis() - msg.getTime()) > 10) {
    			logger.error("all:" + all.get() + ",lazy:" + lazy.incrementAndGet());
    		}
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
