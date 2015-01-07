package com.mokylin.game.server.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.player.message.ReqPlayerGmMessage;

public class ReqPlayerGmHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqPlayerGmHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqPlayerGmMessage msg = (ReqPlayerGmMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
