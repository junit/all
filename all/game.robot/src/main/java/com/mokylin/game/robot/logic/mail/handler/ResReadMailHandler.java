package com.mokylin.game.robot.logic.mail.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.mail.message.ResReadMailMessage;

public class ResReadMailHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResReadMailHandler.class);
    @Override
    public void exec() {
    	try {
    		ResReadMailMessage msg = (ResReadMailMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
