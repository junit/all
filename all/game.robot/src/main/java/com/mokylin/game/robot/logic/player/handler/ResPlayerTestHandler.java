package com.mokylin.game.robot.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.player.message.ResPlayerTestMessage;

public class ResPlayerTestHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerTestHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerTestMessage msg = (ResPlayerTestMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
