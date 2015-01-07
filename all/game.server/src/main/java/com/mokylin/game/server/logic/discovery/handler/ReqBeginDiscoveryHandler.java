package com.mokylin.game.server.logic.discovery.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.discovery.message.ReqBeginDiscoveryMessage;

public class ReqBeginDiscoveryHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqBeginDiscoveryHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqBeginDiscoveryMessage msg = (ReqBeginDiscoveryMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
