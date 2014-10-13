package com.mokylin.game.robot.logic.soultrial.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.soultrial.message.ResStartSoulTrialMessage;

public class ResStartSoulTrialHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResStartSoulTrialHandler.class);
    @Override
    public void exec() {
    	try {
    		ResStartSoulTrialMessage msg = (ResStartSoulTrialMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
