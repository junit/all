package com.mokylin.game.robot.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.player.message.ResPlayerSkillPointRecoverMessage;

public class ResPlayerSkillPointRecoverHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResPlayerSkillPointRecoverHandler.class);
    @Override
    public void exec() {
    	try {
    		ResPlayerSkillPointRecoverMessage msg = (ResPlayerSkillPointRecoverMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
