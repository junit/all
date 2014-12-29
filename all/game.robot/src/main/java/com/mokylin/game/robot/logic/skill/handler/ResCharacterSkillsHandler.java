package com.mokylin.game.robot.logic.skill.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.skill.message.ResCharacterSkillsMessage;

public class ResCharacterSkillsHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResCharacterSkillsHandler.class);
    @Override
    public void exec() {
    	try {
    		ResCharacterSkillsMessage msg = (ResCharacterSkillsMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
