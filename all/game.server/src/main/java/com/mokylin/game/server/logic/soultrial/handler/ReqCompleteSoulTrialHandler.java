package com.mokylin.game.server.logic.soultrial.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.soultrial.message.ReqCompleteSoulTrialMessage;

public class ReqCompleteSoulTrialHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqCompleteSoulTrialHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqCompleteSoulTrialMessage msg = (ReqCompleteSoulTrialMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
