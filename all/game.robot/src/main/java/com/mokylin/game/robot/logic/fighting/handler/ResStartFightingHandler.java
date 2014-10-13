package com.mokylin.game.robot.logic.fighting.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.fighting.message.ResStartFightingMessage;

public class ResStartFightingHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResStartFightingHandler.class);
    @Override
    public void exec() {
    	try {
    		ResStartFightingMessage msg = (ResStartFightingMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
