package com.mokylin.game.robot.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.player.message.ResPlayerGmMessage;

public class ResPlayerGmHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerGmHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerGmMessage msg = (ResPlayerGmMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
