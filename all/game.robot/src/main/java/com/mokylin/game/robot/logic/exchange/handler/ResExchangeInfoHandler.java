package com.mokylin.game.robot.logic.exchange.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.exchange.message.ResExchangeInfoMessage;

public class ResExchangeInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResExchangeInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResExchangeInfoMessage msg = (ResExchangeInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
