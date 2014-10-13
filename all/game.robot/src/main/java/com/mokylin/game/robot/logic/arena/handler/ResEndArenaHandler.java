package com.mokylin.game.robot.logic.arena.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.arena.message.ResEndArenaMessage;

public class ResEndArenaHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResEndArenaHandler.class);
    @Override
    public void exec() {
    	try {
    		ResEndArenaMessage msg = (ResEndArenaMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
