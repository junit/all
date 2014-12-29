package com.mokylin.game.robot.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.butterfly.message.ResIsButterflyOpenMessage;

public class ResIsButterflyOpenHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResIsButterflyOpenHandler.class);
    @Override
    public void exec() {
    	try {
    		ResIsButterflyOpenMessage msg = (ResIsButterflyOpenMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
