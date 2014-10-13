package com.mokylin.game.robot.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.girl.message.ResGirlEnableAssistSkillMessage;

public class ResGirlEnableAssistSkillHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResGirlEnableAssistSkillHandler.class);
    @Override
    public void exec() {
    	try {
    		ResGirlEnableAssistSkillMessage msg = (ResGirlEnableAssistSkillMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
