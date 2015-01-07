package com.mokylin.game.server.logic.soultrial.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.soultrial.message.ReqRestartSoulTrialMessage;

public class ReqRestartSoulTrialHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqRestartSoulTrialHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqRestartSoulTrialMessage msg = (ReqRestartSoulTrialMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
