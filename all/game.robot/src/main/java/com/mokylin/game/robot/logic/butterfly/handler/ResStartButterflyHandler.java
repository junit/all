package com.mokylin.game.robot.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.butterfly.message.ResStartButterflyMessage;

public class ResStartButterflyHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResStartButterflyHandler.class);
    @Override
    public void exec() {
    	try {
    		ResStartButterflyMessage msg = (ResStartButterflyMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
