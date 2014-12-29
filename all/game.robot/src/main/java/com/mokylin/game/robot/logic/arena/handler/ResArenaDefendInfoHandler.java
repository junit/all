package com.mokylin.game.robot.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.arena.message.ResArenaDefendInfoMessage;

public class ResArenaDefendInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResArenaDefendInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResArenaDefendInfoMessage msg = (ResArenaDefendInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
