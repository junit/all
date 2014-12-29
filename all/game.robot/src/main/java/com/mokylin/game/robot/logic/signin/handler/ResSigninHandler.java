package com.mokylin.game.robot.logic.signin.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.signin.message.ResSigninMessage;

public class ResSigninHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSigninHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSigninMessage msg = (ResSigninMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
