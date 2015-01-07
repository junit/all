package com.mokylin.game.server.logic.soultrial.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.soultrial.message.ReqGetAllSoulTrialRewardMessage;

public class ReqGetAllSoulTrialRewardHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqGetAllSoulTrialRewardHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqGetAllSoulTrialRewardMessage msg = (ReqGetAllSoulTrialRewardMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
