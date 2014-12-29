package com.mokylin.game.robot.logic.character.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.character.message.ResUnLockCharacterMessage;

public class ResUnLockCharacterHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResUnLockCharacterHandler.class);
    @Override
    public void exec() {
    	try {
    		ResUnLockCharacterMessage msg = (ResUnLockCharacterMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
