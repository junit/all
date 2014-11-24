package com.mokylin.game.server.logic.account.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.account.message.ReqAccountTestMessage;

public class ReqAccountTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqAccountTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqAccountTestMessage msg = (ReqAccountTestMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
