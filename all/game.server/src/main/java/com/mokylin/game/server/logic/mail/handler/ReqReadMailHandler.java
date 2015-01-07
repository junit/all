package com.mokylin.game.server.logic.mail.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.mail.message.ReqReadMailMessage;

public class ReqReadMailHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqReadMailHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqReadMailMessage msg = (ReqReadMailMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
