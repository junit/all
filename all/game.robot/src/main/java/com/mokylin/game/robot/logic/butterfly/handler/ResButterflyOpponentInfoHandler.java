package com.mokylin.game.robot.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.butterfly.message.ResButterflyOpponentInfoMessage;

public class ResButterflyOpponentInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResButterflyOpponentInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResButterflyOpponentInfoMessage msg = (ResButterflyOpponentInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
