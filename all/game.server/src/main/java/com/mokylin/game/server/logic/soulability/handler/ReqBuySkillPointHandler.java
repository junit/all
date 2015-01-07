package com.mokylin.game.server.logic.soulability.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.soulability.message.ReqBuySkillPointMessage;

public class ReqBuySkillPointHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqBuySkillPointHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqBuySkillPointMessage msg = (ReqBuySkillPointMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
