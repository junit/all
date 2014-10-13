package com.mokylin.game.robot.logic.spa.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.spa.message.ResGetVitalityFromFriendMessage;

public class ResGetVitalityFromFriendHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResGetVitalityFromFriendHandler.class);
    @Override
    public void exec() {
    	try {
    		ResGetVitalityFromFriendMessage msg = (ResGetVitalityFromFriendMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
