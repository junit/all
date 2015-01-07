package com.mokylin.game.server.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.butterfly.message.ReqEndButterflyMessage;

public class ReqEndButterflyHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqEndButterflyHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqEndButterflyMessage msg = (ReqEndButterflyMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
