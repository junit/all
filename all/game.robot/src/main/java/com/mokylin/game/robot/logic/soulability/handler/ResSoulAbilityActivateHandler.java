package com.mokylin.game.robot.logic.soulability.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.soulability.message.ResSoulAbilityActivateMessage;

public class ResSoulAbilityActivateHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSoulAbilityActivateHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSoulAbilityActivateMessage msg = (ResSoulAbilityActivateMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
