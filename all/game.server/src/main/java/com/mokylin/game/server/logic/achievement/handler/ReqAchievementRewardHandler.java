package com.mokylin.game.server.logic.achievement.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.achievement.message.ReqAchievementRewardMessage;

public class ReqAchievementRewardHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqAchievementRewardHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqAchievementRewardMessage msg = (ReqAchievementRewardMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
