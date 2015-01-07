package com.mokylin.game.server.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.arena.message.ReqChangeArenaOpponentMessage;

public class ReqChangeArenaOpponentHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqChangeArenaOpponentHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqChangeArenaOpponentMessage msg = (ReqChangeArenaOpponentMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
