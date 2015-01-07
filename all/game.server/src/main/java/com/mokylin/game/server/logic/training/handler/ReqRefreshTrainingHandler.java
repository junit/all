package com.mokylin.game.server.logic.training.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.training.message.ReqRefreshTrainingMessage;

public class ReqRefreshTrainingHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqRefreshTrainingHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqRefreshTrainingMessage msg = (ReqRefreshTrainingMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
