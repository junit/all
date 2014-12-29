package com.mokylin.game.robot.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.arena.message.ResArenaOpponentInfoMessage;

public class ResArenaOpponentInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResArenaOpponentInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResArenaOpponentInfoMessage msg = (ResArenaOpponentInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
