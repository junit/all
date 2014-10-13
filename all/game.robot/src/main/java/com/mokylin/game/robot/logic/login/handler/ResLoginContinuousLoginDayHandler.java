package com.mokylin.game.robot.logic.login.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.login.message.ResLoginContinuousLoginDayMessage;

public class ResLoginContinuousLoginDayHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResLoginContinuousLoginDayHandler.class);
    @Override
    public void exec() {
    	try {
    		ResLoginContinuousLoginDayMessage msg = (ResLoginContinuousLoginDayMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
