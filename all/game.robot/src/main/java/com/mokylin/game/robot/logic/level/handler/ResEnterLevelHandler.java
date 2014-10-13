package com.mokylin.game.robot.logic.level.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.level.message.ResEnterLevelMessage;

public class ResEnterLevelHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResEnterLevelHandler.class);
    @Override
    public void exec() {
    	try {
    		ResEnterLevelMessage msg = (ResEnterLevelMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
