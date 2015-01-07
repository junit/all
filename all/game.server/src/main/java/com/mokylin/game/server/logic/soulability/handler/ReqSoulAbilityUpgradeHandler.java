package com.mokylin.game.server.logic.soulability.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.soulability.message.ReqSoulAbilityUpgradeMessage;

public class ReqSoulAbilityUpgradeHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqSoulAbilityUpgradeHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqSoulAbilityUpgradeMessage msg = (ReqSoulAbilityUpgradeMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
