package com.mokylin.game.robot.logic.achievement.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.achievement.message.ResAchievementRewardMessage;

public class ResAchievementRewardHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResAchievementRewardHandler.class);
    @Override
    public void exec() {
    	try {
    		ResAchievementRewardMessage msg = (ResAchievementRewardMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
