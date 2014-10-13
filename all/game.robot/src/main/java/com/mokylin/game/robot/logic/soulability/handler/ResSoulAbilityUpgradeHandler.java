package com.mokylin.game.robot.logic.soulability.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.soulability.message.ResSoulAbilityUpgradeMessage;

public class ResSoulAbilityUpgradeHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSoulAbilityUpgradeHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSoulAbilityUpgradeMessage msg = (ResSoulAbilityUpgradeMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
