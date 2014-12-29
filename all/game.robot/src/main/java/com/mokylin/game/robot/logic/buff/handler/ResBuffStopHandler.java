package com.mokylin.game.robot.logic.buff.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.buff.message.ResBuffStopMessage;

public class ResBuffStopHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResBuffStopHandler.class);
    @Override
    public void exec() {
    	try {
    		ResBuffStopMessage msg = (ResBuffStopMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
