package com.mokylin.game.server.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.arena.message.ReqEnterArenaMessage;

public class ReqEnterArenaHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqEnterArenaHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqEnterArenaMessage msg = (ReqEnterArenaMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
