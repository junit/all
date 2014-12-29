package com.mokylin.game.robot.logic.soultrial.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.soultrial.message.ResRestartSoulTrialMessage;

public class ResRestartSoulTrialHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResRestartSoulTrialHandler.class);
    @Override
    public void exec() {
    	try {
    		ResRestartSoulTrialMessage msg = (ResRestartSoulTrialMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
