package com.mokylin.game.robot.logic.spa.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.spa.message.ResUseVitalityMessage;

public class ResUseVitalityHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResUseVitalityHandler.class);
    @Override
    public void exec() {
    	try {
    		ResUseVitalityMessage msg = (ResUseVitalityMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
