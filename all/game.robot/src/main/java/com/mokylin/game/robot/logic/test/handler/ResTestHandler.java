package com.mokylin.game.robot.logic.test.handler;

import com.mokylin.game.core.message.bean.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.robot.logic.test.message.ReqTestMessage;
import com.mokylin.game.robot.logic.test.message.ResTestMessage;

public class ResTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ResTestMessage msg = (ResTestMessage)this.getMessage();
    		long now = System.currentTimeMillis();
    		ReqTestMessage ret = new ReqTestMessage();
    		ret.setTime(now);
    		this.getContext().writeAndFlush(ret);
    		
    		long interval = now - msg.getTime();
    		if (interval > 10) {
    			logger.error("耗时:" + interval);
    		}
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
