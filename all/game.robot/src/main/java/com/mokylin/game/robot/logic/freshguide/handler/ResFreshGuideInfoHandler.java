package com.mokylin.game.robot.logic.freshguide.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.freshguide.message.ResFreshGuideInfoMessage;

public class ResFreshGuideInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResFreshGuideInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResFreshGuideInfoMessage msg = (ResFreshGuideInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
