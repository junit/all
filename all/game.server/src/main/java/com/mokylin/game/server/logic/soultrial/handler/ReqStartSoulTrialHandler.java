package com.mokylin.game.server.logic.soultrial.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.soultrial.message.ReqStartSoulTrialMessage;

public class ReqStartSoulTrialHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqStartSoulTrialHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqStartSoulTrialMessage msg = (ReqStartSoulTrialMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
