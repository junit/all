package com.mokylin.game.server.logic.account.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.account.message.ReqAccountLoginMessage;

public class ReqAccountLoginHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqAccountLoginHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqAccountLoginMessage msg = (ReqAccountLoginMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
