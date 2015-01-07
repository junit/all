package com.mokylin.game.server.logic.freshguide.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.freshguide.message.ReqSaveFreshGuideMessage;

public class ReqSaveFreshGuideHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqSaveFreshGuideHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqSaveFreshGuideMessage msg = (ReqSaveFreshGuideMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
