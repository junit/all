package com.mokylin.game.robot.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.girl.message.ResGirlGetInfoMessage;

public class ResGirlGetInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResGirlGetInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResGirlGetInfoMessage msg = (ResGirlGetInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
