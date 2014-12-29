package com.mokylin.game.robot.logic.mail.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.mail.message.ResGetMailAttachMessage;

public class ResGetMailAttachHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResGetMailAttachHandler.class);
    @Override
    public void exec() {
    	try {
    		ResGetMailAttachMessage msg = (ResGetMailAttachMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
