package com.mokylin.game.robot.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.butterfly.message.ResEndButterflyMessage;

public class ResEndButterflyHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResEndButterflyHandler.class);
    @Override
    public void exec() {
    	try {
    		ResEndButterflyMessage msg = (ResEndButterflyMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
