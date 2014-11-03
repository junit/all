package com.mokylin.game.robot.logic.player.handler;

import com.mokylin.game.core.message.Handler;

import org.apache.log4j.Logger;

import com.mokylin.game.robot.logic.player.message.ResPlayerActivityDiscountMessage;

public class ResPlayerActivityDiscountHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerActivityDiscountHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerActivityDiscountMessage msg = (ResPlayerActivityDiscountMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
