package com.mokylin.game.server.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.arena.message.ReqEndArenaMessage;

public class ReqEndArenaHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqEndArenaHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqEndArenaMessage msg = (ReqEndArenaMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
