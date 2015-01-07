package com.mokylin.game.server.logic.destiny.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.destiny.message.ReqDestinyRefreshMessage;

public class ReqDestinyRefreshHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqDestinyRefreshHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqDestinyRefreshMessage msg = (ReqDestinyRefreshMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
