package com.mokylin.game.robot.logic.soultrial.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.soultrial.message.ResSoulTrialInfoMessage;

public class ResSoulTrialInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSoulTrialInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSoulTrialInfoMessage msg = (ResSoulTrialInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
