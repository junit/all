package com.mokylin.game.robot.logic.destiny.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.destiny.message.ResDestinyInfoMessage;

public class ResDestinyInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResDestinyInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResDestinyInfoMessage msg = (ResDestinyInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
