package com.mokylin.game.robot.logic.achievement.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.achievement.message.ResAchievementInfoMessage;

public class ResAchievementInfoHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResAchievementInfoHandler.class);
    @Override
    public void exec() {
    	try {
    		ResAchievementInfoMessage msg = (ResAchievementInfoMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
