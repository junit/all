package com.mokylin.game.server.logic.login.handler;

import com.mokylin.game.core.message.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.server.logic.login.message.ReqLoginTestMessage;

public class ReqLoginTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqLoginTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqLoginTestMessage msg = (ReqLoginTestMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
