package com.mokylin.game.robot.logic.buff.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.buff.message.ResBuffStartMessage;

public class ResBuffStartHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResBuffStartHandler.class);
    @Override
    public void exec() {
    	try {
    		ResBuffStartMessage msg = (ResBuffStartMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
