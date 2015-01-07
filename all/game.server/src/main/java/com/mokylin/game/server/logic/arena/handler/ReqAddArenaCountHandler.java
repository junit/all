package com.mokylin.game.server.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.arena.message.ReqAddArenaCountMessage;

public class ReqAddArenaCountHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqAddArenaCountHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqAddArenaCountMessage msg = (ReqAddArenaCountMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
