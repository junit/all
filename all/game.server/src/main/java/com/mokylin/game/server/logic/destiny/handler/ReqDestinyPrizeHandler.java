package com.mokylin.game.server.logic.destiny.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.destiny.message.ReqDestinyPrizeMessage;

public class ReqDestinyPrizeHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqDestinyPrizeHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqDestinyPrizeMessage msg = (ReqDestinyPrizeMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
