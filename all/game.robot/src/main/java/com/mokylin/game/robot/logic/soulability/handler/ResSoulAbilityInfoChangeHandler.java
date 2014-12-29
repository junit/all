package com.mokylin.game.robot.logic.soulability.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.soulability.message.ResSoulAbilityInfoChangeMessage;

public class ResSoulAbilityInfoChangeHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResSoulAbilityInfoChangeHandler.class);
    @Override
    public void exec() {
    	try {
    		ResSoulAbilityInfoChangeMessage msg = (ResSoulAbilityInfoChangeMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
