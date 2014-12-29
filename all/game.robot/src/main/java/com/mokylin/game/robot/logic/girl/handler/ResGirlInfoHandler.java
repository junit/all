package com.mokylin.game.robot.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.girl.message.ResGirlInfoMessage;

public class ResGirlInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResGirlInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResGirlInfoMessage msg = (ResGirlInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
