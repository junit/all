package com.mokylin.game.server.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.girl.message.ReqGirlInfoMessage;

public class ReqGirlInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqGirlInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqGirlInfoMessage msg = (ReqGirlInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
