package com.mokylin.game.server.logic.exchange.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.exchange.message.ReqSoulExchangeMessage;

public class ReqSoulExchangeHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqSoulExchangeHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqSoulExchangeMessage msg = (ReqSoulExchangeMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
