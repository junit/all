package com.mokylin.game.robot.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.arena.message.ResPlayerArenaInfoMessage;

public class ResPlayerArenaInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerArenaInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerArenaInfoMessage msg = (ResPlayerArenaInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
