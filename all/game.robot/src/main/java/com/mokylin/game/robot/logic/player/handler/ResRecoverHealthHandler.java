package com.mokylin.game.robot.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.player.message.ResRecoverHealthMessage;

public class ResRecoverHealthHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResRecoverHealthHandler.class);
    @Override
    public void exec() {
    	try {
    		ResRecoverHealthMessage msg = (ResRecoverHealthMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
