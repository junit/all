package com.mokylin.game.robot.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.butterfly.message.ResButterflyFightNowMessage;

public class ResButterflyFightNowHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResButterflyFightNowHandler.class);
    @Override
    public void exec() {
    	try {
    		ResButterflyFightNowMessage msg = (ResButterflyFightNowMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
