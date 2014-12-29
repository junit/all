package com.mokylin.game.robot.logic.fighting.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.fighting.message.ResEndFightingMessage;

public class ResEndFightingHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResEndFightingHandler.class);
    @Override
    public void exec() {
    	try {
    		ResEndFightingMessage msg = (ResEndFightingMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
