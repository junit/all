package com.mokylin.game.server.logic.level.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.level.message.ReqCompleteLevelMessage;

public class ReqCompleteLevelHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqCompleteLevelHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqCompleteLevelMessage msg = (ReqCompleteLevelMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
