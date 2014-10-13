package com.mokylin.game.robot.logic.discovery.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.discovery.message.ResBeginDiscoveryMessage;

public class ResBeginDiscoveryHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResBeginDiscoveryHandler.class);
    @Override
    public void exec() {
    	try {
    		ResBeginDiscoveryMessage msg = (ResBeginDiscoveryMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
