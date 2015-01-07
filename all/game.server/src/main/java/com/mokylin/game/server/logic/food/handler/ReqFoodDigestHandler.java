package com.mokylin.game.server.logic.food.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.food.message.ReqFoodDigestMessage;

public class ReqFoodDigestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqFoodDigestHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqFoodDigestMessage msg = (ReqFoodDigestMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
