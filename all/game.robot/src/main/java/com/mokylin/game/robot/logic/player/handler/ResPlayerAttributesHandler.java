package com.mokylin.game.robot.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.player.message.ResPlayerAttributesMessage;

public class ResPlayerAttributesHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerAttributesHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerAttributesMessage msg = (ResPlayerAttributesMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
