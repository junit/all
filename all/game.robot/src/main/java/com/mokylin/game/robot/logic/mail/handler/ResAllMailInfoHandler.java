package com.mokylin.game.robot.logic.mail.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.mail.message.ResAllMailInfoMessage;

public class ResAllMailInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResAllMailInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResAllMailInfoMessage msg = (ResAllMailInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
