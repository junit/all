package com.mokylin.game.robot.logic.reward.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.reward.message.ResRewardResultMessage;

public class ResRewardResultHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResRewardResultHandler.class);
    @Override
    public void exec() {
    	try {
    		ResRewardResultMessage msg = (ResRewardResultMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
