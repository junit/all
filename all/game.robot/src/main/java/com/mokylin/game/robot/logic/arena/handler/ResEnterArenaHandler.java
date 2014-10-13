package com.mokylin.game.robot.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.arena.message.ResEnterArenaMessage;

public class ResEnterArenaHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResEnterArenaHandler.class);
    @Override
    public void exec() {
    	try {
    		ResEnterArenaMessage msg = (ResEnterArenaMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
