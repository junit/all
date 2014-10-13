package com.mokylin.game.robot.logic.food.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.food.message.ResFoodClearTimeMessage;

public class ResFoodClearTimeHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResFoodClearTimeHandler.class);
    @Override
    public void exec() {
    	try {
    		ResFoodClearTimeMessage msg = (ResFoodClearTimeMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
