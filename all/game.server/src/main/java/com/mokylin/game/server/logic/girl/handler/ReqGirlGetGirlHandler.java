package com.mokylin.game.server.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.girl.message.ReqGirlGetGirlMessage;

public class ReqGirlGetGirlHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqGirlGetGirlHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqGirlGetGirlMessage msg = (ReqGirlGetGirlMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
