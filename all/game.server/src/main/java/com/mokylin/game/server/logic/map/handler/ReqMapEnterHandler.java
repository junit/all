package com.mokylin.game.server.logic.map.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.map.message.ReqMapEnterMessage;

public class ReqMapEnterHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqMapEnterHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqMapEnterMessage msg = (ReqMapEnterMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
