package com.mokylin.game.robot.logic.butterfly.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.butterfly.message.ResEnterButterflyMessage;

public class ResEnterButterflyHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResEnterButterflyHandler.class);
    @Override
    public void exec() {
    	try {
    		ResEnterButterflyMessage msg = (ResEnterButterflyMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
