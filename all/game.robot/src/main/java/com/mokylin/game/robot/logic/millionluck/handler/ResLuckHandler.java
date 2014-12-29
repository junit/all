package com.mokylin.game.robot.logic.millionluck.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.millionluck.message.ResLuckMessage;

public class ResLuckHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResLuckHandler.class);
    @Override
    public void exec() {
    	try {
    		ResLuckMessage msg = (ResLuckMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
