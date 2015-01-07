package com.mokylin.game.server.logic.level.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.level.message.ReqEnterLevelMessage;

public class ReqEnterLevelHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqEnterLevelHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqEnterLevelMessage msg = (ReqEnterLevelMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
