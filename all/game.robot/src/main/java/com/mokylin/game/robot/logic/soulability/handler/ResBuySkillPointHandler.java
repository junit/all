package com.mokylin.game.robot.logic.soulability.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.soulability.message.ResBuySkillPointMessage;

public class ResBuySkillPointHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResBuySkillPointHandler.class);
    @Override
    public void exec() {
    	try {
    		ResBuySkillPointMessage msg = (ResBuySkillPointMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
