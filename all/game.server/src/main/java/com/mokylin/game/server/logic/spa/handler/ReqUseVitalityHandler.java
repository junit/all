package com.mokylin.game.server.logic.spa.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.spa.message.ReqUseVitalityMessage;

public class ReqUseVitalityHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqUseVitalityHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqUseVitalityMessage msg = (ReqUseVitalityMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
