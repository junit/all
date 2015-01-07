package com.mokylin.game.server.logic.destiny.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.destiny.message.ReqDestinyInfoMessage;

public class ReqDestinyInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqDestinyInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqDestinyInfoMessage msg = (ReqDestinyInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
