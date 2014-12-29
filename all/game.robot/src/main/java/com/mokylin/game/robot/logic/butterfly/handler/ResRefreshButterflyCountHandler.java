package com.mokylin.game.robot.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.butterfly.message.ResRefreshButterflyCountMessage;

public class ResRefreshButterflyCountHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResRefreshButterflyCountHandler.class);
    @Override
    public void exec() {
    	try {
    		ResRefreshButterflyCountMessage msg = (ResRefreshButterflyCountMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
