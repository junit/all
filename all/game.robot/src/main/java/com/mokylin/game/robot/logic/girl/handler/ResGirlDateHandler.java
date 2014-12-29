package com.mokylin.game.robot.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.girl.message.ResGirlDateMessage;

public class ResGirlDateHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResGirlDateHandler.class);
    @Override
    public void exec() {
    	try {
    		ResGirlDateMessage msg = (ResGirlDateMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
