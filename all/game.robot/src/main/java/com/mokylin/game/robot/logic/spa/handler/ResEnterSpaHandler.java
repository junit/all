package com.mokylin.game.robot.logic.spa.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.spa.message.ResEnterSpaMessage;

public class ResEnterSpaHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResEnterSpaHandler.class);
    @Override
    public void exec() {
    	try {
    		ResEnterSpaMessage msg = (ResEnterSpaMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
