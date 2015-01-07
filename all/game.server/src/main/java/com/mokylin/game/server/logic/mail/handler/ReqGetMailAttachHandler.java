package com.mokylin.game.server.logic.mail.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.mail.message.ReqGetMailAttachMessage;

public class ReqGetMailAttachHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqGetMailAttachHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqGetMailAttachMessage msg = (ReqGetMailAttachMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
