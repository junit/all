package com.mokylin.game.server.logic.soultrial.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.soultrial.message.ReqAddSoulTrialCountMessage;

public class ReqAddSoulTrialCountHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqAddSoulTrialCountHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqAddSoulTrialCountMessage msg = (ReqAddSoulTrialCountMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
