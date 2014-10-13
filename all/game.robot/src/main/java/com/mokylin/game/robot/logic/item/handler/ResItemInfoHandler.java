package com.mokylin.game.robot.logic.item.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.item.message.ResItemInfoMessage;

public class ResItemInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResItemInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResItemInfoMessage msg = (ResItemInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
