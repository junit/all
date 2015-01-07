package com.mokylin.game.server.logic.player.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.player.message.ReqPlayerSkillPointRecoverMessage;

public class ReqPlayerSkillPointRecoverHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqPlayerSkillPointRecoverHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqPlayerSkillPointRecoverMessage msg = (ReqPlayerSkillPointRecoverMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
