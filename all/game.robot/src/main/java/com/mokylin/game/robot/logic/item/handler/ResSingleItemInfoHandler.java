package com.mokylin.game.robot.logic.item.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.item.message.ResSingleItemInfoMessage;

public class ResSingleItemInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSingleItemInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSingleItemInfoMessage msg = (ResSingleItemInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
