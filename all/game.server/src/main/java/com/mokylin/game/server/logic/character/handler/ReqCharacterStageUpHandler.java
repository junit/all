package com.mokylin.game.server.logic.character.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.server.logic.character.message.ReqCharacterStageUpMessage;

public class ReqCharacterStageUpHandler extends Handler{
	private static Logger logger = Logger.getLogger(ReqCharacterStageUpHandler.class);
    @Override
    public void exec() {
    	try {
    		ReqCharacterStageUpMessage msg = (ReqCharacterStageUpMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
