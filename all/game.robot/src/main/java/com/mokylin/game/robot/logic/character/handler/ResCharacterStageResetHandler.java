package com.mokylin.game.robot.logic.character.handler;

import com.mokylin.game.core.message.bean.Handler;
import org.apache.log4j.Logger;
import com.mokylin.game.robot.logic.character.message.ResCharacterStageResetMessage;

public class ResCharacterStageResetHandler extends Handler{
	private static Logger logger = Logger.getLogger(ResCharacterStageResetHandler.class);
    @Override
    public void exec() {
    	try {
    		ResCharacterStageResetMessage msg = (ResCharacterStageResetMessage)this.getMessage();
    		// TODO
      } catch (Exception e) {
			logger.error(e, e);
		}
    }
}
