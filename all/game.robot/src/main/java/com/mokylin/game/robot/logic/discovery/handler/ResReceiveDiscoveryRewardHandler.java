package com.mokylin.game.robot.logic.discovery.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.discovery.message.ResReceiveDiscoveryRewardMessage;

public class ResReceiveDiscoveryRewardHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResReceiveDiscoveryRewardHandler.class);
    @Override
    public void exec() {
    	try {
    		ResReceiveDiscoveryRewardMessage msg = (ResReceiveDiscoveryRewardMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
