package com.mokylin.game.server.logic.character.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.character.message.ReqCharacterStageResetMessage;

public class ReqCharacterStageResetHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqCharacterStageResetHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqCharacterStageResetMessage msg = (ReqCharacterStageResetMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
