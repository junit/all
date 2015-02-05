package com.mokylin.game.robot.logic.login.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.login.message.ResLoginTestMessage;

public class ResLoginTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResLoginTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ResLoginTestMessage msg = (ResLoginTestMessage)this.getMessage();
    		logger.error("len:" + msg.getStr().length() + ",time:" + (System.currentTimeMillis() - msg.getTime()));
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
