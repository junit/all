package com.mokylin.game.robot.logic.player.handler;

import com.mokylin.game.core.message.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.robot.logic.player.message.ResPlayerAttributeMessage;

public class ResPlayerAttributeHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerAttributeHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerAttributeMessage msg = (ResPlayerAttributeMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
