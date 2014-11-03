package com.mokylin.game.robot.logic.login.handler;

import com.mokylin.game.core.message.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.robot.logic.login.message.ResCreatePlayerResultMessage;

public class ResCreatePlayerResultHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResCreatePlayerResultHandler.class);
    @Override
    public void exec() {
    	try {
    		ResCreatePlayerResultMessage msg = (ResCreatePlayerResultMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
