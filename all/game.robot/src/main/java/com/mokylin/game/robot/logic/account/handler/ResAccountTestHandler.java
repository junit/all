package com.mokylin.game.robot.logic.account.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.account.message.ResAccountTestMessage;

public class ResAccountTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResAccountTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ResAccountTestMessage msg = (ResAccountTestMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
