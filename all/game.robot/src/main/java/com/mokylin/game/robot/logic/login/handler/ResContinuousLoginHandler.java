package com.mokylin.game.robot.logic.login.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.login.message.ResContinuousLoginMessage;

public class ResContinuousLoginHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResContinuousLoginHandler.class);
    @Override
    public void exec() {
    	try {
    		ResContinuousLoginMessage msg = (ResContinuousLoginMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
