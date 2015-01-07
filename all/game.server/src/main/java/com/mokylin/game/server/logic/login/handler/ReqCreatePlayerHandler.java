package com.mokylin.game.server.logic.login.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.login.message.ReqCreatePlayerMessage;

public class ReqCreatePlayerHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqCreatePlayerHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqCreatePlayerMessage msg = (ReqCreatePlayerMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
