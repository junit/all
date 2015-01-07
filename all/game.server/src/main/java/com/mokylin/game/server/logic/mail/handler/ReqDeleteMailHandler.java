package com.mokylin.game.server.logic.mail.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.mail.message.ReqDeleteMailMessage;

public class ReqDeleteMailHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqDeleteMailHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqDeleteMailMessage msg = (ReqDeleteMailMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
