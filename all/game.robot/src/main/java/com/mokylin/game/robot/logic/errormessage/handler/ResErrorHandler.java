package com.mokylin.game.robot.logic.errormessage.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.errormessage.message.ResErrorMessage;

public class ResErrorHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResErrorHandler.class);
    @Override
    public void exec() {
    	try {
    		ResErrorMessage msg = (ResErrorMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
