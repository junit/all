package com.mokylin.game.robot.logic.training.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.training.message.ResRefreshTrainingMessage;

public class ResRefreshTrainingHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResRefreshTrainingHandler.class);
    @Override
    public void exec() {
    	try {
    		ResRefreshTrainingMessage msg = (ResRefreshTrainingMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
