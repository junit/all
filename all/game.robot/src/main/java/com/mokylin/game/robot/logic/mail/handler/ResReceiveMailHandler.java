package com.mokylin.game.robot.logic.mail.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.mail.message.ResReceiveMailMessage;

public class ResReceiveMailHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResReceiveMailHandler.class);
    @Override
    public void exec() {
    	try {
    		ResReceiveMailMessage msg = (ResReceiveMailMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
