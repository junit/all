package com.mokylin.game.robot.logic.login.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.login.message.ResPlayerDetailMessage;

public class ResPlayerDetailHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerDetailHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerDetailMessage msg = (ResPlayerDetailMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
