package com.mokylin.game.robot.logic.login.handler;

import org.apache.log4j.Logger;

import com.mokylin.game.core.message.Handler;
import com.mokylin.game.robot.logic.login.message.ResGameStartMessage;

public class ResGameStartHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResGameStartHandler.class);
	
    @Override
    public void exec() {
    	try {
    		ResGameStartMessage msg = (ResGameStartMessage)this.getMessage();
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
