package com.mokylin.game.server.logic.girl.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.girl.message.ReqGirlDisableAssistSkillMessage;

public class ReqGirlDisableAssistSkillHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqGirlDisableAssistSkillHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqGirlDisableAssistSkillMessage msg = (ReqGirlDisableAssistSkillMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
