package com.mokylin.game.robot.logic.skill.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.skill.message.ResSkillAssistSkillMessage;

public class ResSkillAssistSkillHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSkillAssistSkillHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSkillAssistSkillMessage msg = (ResSkillAssistSkillMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
