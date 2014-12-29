package com.mokylin.game.robot.logic.discovery.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.discovery.message.ResDiscoveryCharacterRefreshMessage;

public class ResDiscoveryCharacterRefreshHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResDiscoveryCharacterRefreshHandler.class);
    @Override
    public void exec() {
    	try {
    		ResDiscoveryCharacterRefreshMessage msg = (ResDiscoveryCharacterRefreshMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
