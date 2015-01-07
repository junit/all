package com.mokylin.game.server.logic.destiny.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.destiny.message.ReqDestinyFightMessage;

public class ReqDestinyFightHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqDestinyFightHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqDestinyFightMessage msg = (ReqDestinyFightMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
