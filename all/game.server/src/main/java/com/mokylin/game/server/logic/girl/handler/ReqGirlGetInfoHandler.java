package com.mokylin.game.server.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.girl.message.ReqGirlGetInfoMessage;

public class ReqGirlGetInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqGirlGetInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqGirlGetInfoMessage msg = (ReqGirlGetInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
