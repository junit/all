package com.mokylin.game.server.logic.fighting.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.fighting.message.ReqEndFightingMessage;

public class ReqEndFightingHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqEndFightingHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqEndFightingMessage msg = (ReqEndFightingMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
