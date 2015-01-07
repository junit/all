package com.mokylin.game.server.logic.level.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.level.message.ReqMopMessage;

public class ReqMopHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqMopHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqMopMessage msg = (ReqMopMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
