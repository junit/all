package com.mokylin.game.robot.logic.map.handler;

import com.mokylin.game.core.message.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.map.message.ResMapAllObjectMessage;

public class ResMapAllObjectHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResMapAllObjectHandler.class);
    @Override
    public void exec() {
    	try {
    		ResMapAllObjectMessage msg = (ResMapAllObjectMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
