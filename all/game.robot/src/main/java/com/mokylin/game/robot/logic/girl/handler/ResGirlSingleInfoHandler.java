package com.mokylin.game.robot.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.girl.message.ResGirlSingleInfoMessage;

public class ResGirlSingleInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResGirlSingleInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResGirlSingleInfoMessage msg = (ResGirlSingleInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
