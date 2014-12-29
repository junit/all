package com.mokylin.game.robot.logic.food.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.food.message.ResFoodCookMessage;

public class ResFoodCookHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResFoodCookHandler.class);
    @Override
    public void exec() {
    	try {
    		ResFoodCookMessage msg = (ResFoodCookMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
