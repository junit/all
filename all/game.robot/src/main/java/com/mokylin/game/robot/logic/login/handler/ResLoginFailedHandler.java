package com.mokylin.game.robot.logic.login.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.login.message.ResLoginFailedMessage;

public class ResLoginFailedHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResLoginFailedHandler.class);
    @Override
    public void exec() {
    	try {
    		ResLoginFailedMessage msg = (ResLoginFailedMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
