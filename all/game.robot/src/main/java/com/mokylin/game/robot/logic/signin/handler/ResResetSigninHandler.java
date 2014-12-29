package com.mokylin.game.robot.logic.signin.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.signin.message.ResResetSigninMessage;

public class ResResetSigninHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResResetSigninHandler.class);
    @Override
    public void exec() {
    	try {
    		ResResetSigninMessage msg = (ResResetSigninMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
