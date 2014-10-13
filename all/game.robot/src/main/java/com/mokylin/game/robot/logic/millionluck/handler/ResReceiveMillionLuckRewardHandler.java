package com.mokylin.game.robot.logic.millionluck.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.millionluck.message.ResReceiveMillionLuckRewardMessage;

public class ResReceiveMillionLuckRewardHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResReceiveMillionLuckRewardHandler.class);
    @Override
    public void exec() {
    	try {
    		ResReceiveMillionLuckRewardMessage msg = (ResReceiveMillionLuckRewardMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
