package com.mokylin.game.server.logic.soultrial.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.soultrial.message.ReqGetOneSoulTrialRewardMessage;

public class ReqGetOneSoulTrialRewardHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqGetOneSoulTrialRewardHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqGetOneSoulTrialRewardMessage msg = (ReqGetOneSoulTrialRewardMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
