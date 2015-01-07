package com.mokylin.game.server.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.girl.message.ReqGirlDateMessage;

public class ReqGirlDateHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqGirlDateHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqGirlDateMessage msg = (ReqGirlDateMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
