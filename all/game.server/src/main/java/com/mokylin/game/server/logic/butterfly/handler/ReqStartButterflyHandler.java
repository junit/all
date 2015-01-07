package com.mokylin.game.server.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.butterfly.message.ReqStartButterflyMessage;

public class ReqStartButterflyHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqStartButterflyHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqStartButterflyMessage msg = (ReqStartButterflyMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
