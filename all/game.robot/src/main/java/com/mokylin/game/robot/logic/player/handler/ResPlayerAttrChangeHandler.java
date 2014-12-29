package com.mokylin.game.robot.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.player.message.ResPlayerAttrChangeMessage;

public class ResPlayerAttrChangeHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerAttrChangeHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerAttrChangeMessage msg = (ResPlayerAttrChangeMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
