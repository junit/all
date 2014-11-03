package com.mokylin.game.robot.logic.login.handler;

import com.mokylin.game.core.message.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.robot.logic.login.message.ResPlayerBaseInfoMessage;

public class ResPlayerBaseInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerBaseInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerBaseInfoMessage msg = (ResPlayerBaseInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
