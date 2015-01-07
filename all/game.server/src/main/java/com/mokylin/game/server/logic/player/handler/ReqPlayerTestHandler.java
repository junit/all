package com.mokylin.game.server.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.player.message.ReqPlayerTestMessage;

public class ReqPlayerTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqPlayerTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqPlayerTestMessage msg = (ReqPlayerTestMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
