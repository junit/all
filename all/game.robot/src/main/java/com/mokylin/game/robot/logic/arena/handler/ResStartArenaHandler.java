package com.mokylin.game.robot.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.arena.message.ResStartArenaMessage;

public class ResStartArenaHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResStartArenaHandler.class);
    @Override
    public void exec() {
    	try {
    		ResStartArenaMessage msg = (ResStartArenaMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
