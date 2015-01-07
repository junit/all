package com.mokylin.game.server.logic.discovery.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.discovery.message.ReqReceiveDiscoveryRewardMessage;

public class ReqReceiveDiscoveryRewardHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqReceiveDiscoveryRewardHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqReceiveDiscoveryRewardMessage msg = (ReqReceiveDiscoveryRewardMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
