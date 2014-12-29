package com.mokylin.game.robot.logic.playersync.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.playersync.message.ResPlayerSyncMessage;

public class ResPlayerSyncHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerSyncHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerSyncMessage msg = (ResPlayerSyncMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
