package com.mokylin.game.robot.logic.food.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.food.message.ResFoodTimesMessage;

public class ResFoodTimesHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResFoodTimesHandler.class);
    @Override
    public void exec() {
    	try {
    		ResFoodTimesMessage msg = (ResFoodTimesMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
