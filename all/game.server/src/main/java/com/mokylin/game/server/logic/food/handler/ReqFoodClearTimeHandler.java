package com.mokylin.game.server.logic.food.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.food.message.ReqFoodClearTimeMessage;

public class ReqFoodClearTimeHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqFoodClearTimeHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqFoodClearTimeMessage msg = (ReqFoodClearTimeMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
