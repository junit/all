package com.mokylin.game.server.logic.character.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.character.message.ReqUnLockCharacterMessage;

public class ReqUnLockCharacterHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqUnLockCharacterHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqUnLockCharacterMessage msg = (ReqUnLockCharacterMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
