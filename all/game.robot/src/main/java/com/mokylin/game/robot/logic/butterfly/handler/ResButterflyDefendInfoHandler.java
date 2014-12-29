package com.mokylin.game.robot.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.butterfly.message.ResButterflyDefendInfoMessage;

public class ResButterflyDefendInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResButterflyDefendInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResButterflyDefendInfoMessage msg = (ResButterflyDefendInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
