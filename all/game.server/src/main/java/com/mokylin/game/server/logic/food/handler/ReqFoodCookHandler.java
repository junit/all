package com.mokylin.game.server.logic.food.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.food.message.ReqFoodCookMessage;

public class ReqFoodCookHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqFoodCookHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqFoodCookMessage msg = (ReqFoodCookMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
