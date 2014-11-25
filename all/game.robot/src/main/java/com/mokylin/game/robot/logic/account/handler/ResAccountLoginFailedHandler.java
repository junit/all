package com.mokylin.game.robot.logic.account.handler;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.robot.logic.account.message.ResAccountLoginFailedMessage;

public class ResAccountLoginFailedHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResAccountLoginFailedHandler.class);
	
	private static AtomicInteger suc = new AtomicInteger(0);
	private static AtomicInteger fail = new AtomicInteger(0);
	
    @Override
    public void exec() {
    	try {
    		ResAccountLoginFailedMessage msg = (ResAccountLoginFailedMessage)this.getMessage();
    		if (msg.getErr() == 0) {
    			suc.incrementAndGet();
    		} else {
    			fail.incrementAndGet();
    		}
    		System.err.println("suc:" + suc + ",fail:" + fail);
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
