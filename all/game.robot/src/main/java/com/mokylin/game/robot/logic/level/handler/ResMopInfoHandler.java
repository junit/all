package com.mokylin.game.robot.logic.level.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.level.message.ResMopInfoMessage;

public class ResMopInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResMopInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResMopInfoMessage msg = (ResMopInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
