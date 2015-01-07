package com.mokylin.game.server.logic.training.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.training.message.ReqEnterTrainingMessage;

public class ReqEnterTrainingHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqEnterTrainingHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqEnterTrainingMessage msg = (ReqEnterTrainingMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
