package com.mokylin.game.server.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.butterfly.message.ReqChangeButterflyOpponentMessage;

public class ReqChangeButterflyOpponentHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqChangeButterflyOpponentHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqChangeButterflyOpponentMessage msg = (ReqChangeButterflyOpponentMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
