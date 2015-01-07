package com.mokylin.game.server.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.arena.message.ReqFightNowMessage;

public class ReqFightNowHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqFightNowHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqFightNowMessage msg = (ReqFightNowMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
