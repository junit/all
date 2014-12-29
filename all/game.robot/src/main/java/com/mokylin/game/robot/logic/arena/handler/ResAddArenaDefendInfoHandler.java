package com.mokylin.game.robot.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.arena.message.ResAddArenaDefendInfoMessage;

public class ResAddArenaDefendInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResAddArenaDefendInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResAddArenaDefendInfoMessage msg = (ResAddArenaDefendInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
