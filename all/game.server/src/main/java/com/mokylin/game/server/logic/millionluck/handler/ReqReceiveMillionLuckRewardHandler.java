package com.mokylin.game.server.logic.millionluck.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.millionluck.message.ReqReceiveMillionLuckRewardMessage;

public class ReqReceiveMillionLuckRewardHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqReceiveMillionLuckRewardHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqReceiveMillionLuckRewardMessage msg = (ReqReceiveMillionLuckRewardMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
