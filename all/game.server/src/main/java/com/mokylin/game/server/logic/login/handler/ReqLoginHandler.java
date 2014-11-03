package com.mokylin.game.server.logic.login.handler;

import com.mokylin.game.core.message.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.server.logic.login.message.ReqLoginMessage;

public class ReqLoginHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqLoginHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqLoginMessage msg = (ReqLoginMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
