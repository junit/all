package com.mokylin.game.robot.logic.spa.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.spa.message.ResSpaTimesMessage;

public class ResSpaTimesHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSpaTimesHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSpaTimesMessage msg = (ResSpaTimesMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
