package com.mokylin.game.robot.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.player.message.ResPlayerHealthRecoverMessage;

public class ResPlayerHealthRecoverHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerHealthRecoverHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerHealthRecoverMessage msg = (ResPlayerHealthRecoverMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
