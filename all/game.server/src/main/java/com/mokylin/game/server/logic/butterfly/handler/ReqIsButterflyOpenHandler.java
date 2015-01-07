package com.mokylin.game.server.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.butterfly.message.ReqIsButterflyOpenMessage;

public class ReqIsButterflyOpenHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqIsButterflyOpenHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqIsButterflyOpenMessage msg = (ReqIsButterflyOpenMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
