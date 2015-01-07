package com.mokylin.game.server.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.arena.message.ReqStartArenaMessage;

public class ReqStartArenaHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqStartArenaHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqStartArenaMessage msg = (ReqStartArenaMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
