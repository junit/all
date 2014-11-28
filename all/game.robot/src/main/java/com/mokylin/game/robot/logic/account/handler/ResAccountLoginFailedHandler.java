package com.mokylin.game.robot.logic.account.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.account.message.ResAccountLoginFailedMessage;

public class ResAccountLoginFailedHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResAccountLoginFailedHandler.class);
    @Override
    public void exec() {
    	try {
    		ResAccountLoginFailedMessage msg = (ResAccountLoginFailedMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
