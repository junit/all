package com.mokylin.game.robot.logic.destiny.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.destiny.message.ResDestinyFightMessage;

public class ResDestinyFightHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResDestinyFightHandler.class);
    @Override
    public void exec() {
    	try {
    		ResDestinyFightMessage msg = (ResDestinyFightMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
