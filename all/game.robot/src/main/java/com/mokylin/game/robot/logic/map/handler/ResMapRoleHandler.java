package com.mokylin.game.robot.logic.map.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.map.message.ResMapRoleMessage;

public class ResMapRoleHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResMapRoleHandler.class);
    @Override
    public void exec() {
    	try {
    		ResMapRoleMessage msg = (ResMapRoleMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
