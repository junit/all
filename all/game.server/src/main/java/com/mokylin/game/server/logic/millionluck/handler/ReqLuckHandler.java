package com.mokylin.game.server.logic.millionluck.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.millionluck.message.ReqLuckMessage;

public class ReqLuckHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqLuckHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqLuckMessage msg = (ReqLuckMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
