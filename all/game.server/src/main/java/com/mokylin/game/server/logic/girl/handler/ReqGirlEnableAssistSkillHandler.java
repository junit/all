package com.mokylin.game.server.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.girl.message.ReqGirlEnableAssistSkillMessage;

public class ReqGirlEnableAssistSkillHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqGirlEnableAssistSkillHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqGirlEnableAssistSkillMessage msg = (ReqGirlEnableAssistSkillMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
