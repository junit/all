package com.mokylin.game.robot.logic.level.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.level.message.ResClearanceInfoMessage;

public class ResClearanceInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResClearanceInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResClearanceInfoMessage msg = (ResClearanceInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
