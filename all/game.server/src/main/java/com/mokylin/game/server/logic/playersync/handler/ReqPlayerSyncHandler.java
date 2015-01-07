package com.mokylin.game.server.logic.playersync.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.playersync.message.ReqPlayerSyncMessage;

public class ReqPlayerSyncHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqPlayerSyncHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqPlayerSyncMessage msg = (ReqPlayerSyncMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
